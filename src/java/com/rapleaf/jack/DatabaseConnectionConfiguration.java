package com.rapleaf.jack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import org.jvyaml.YAML;

public class DatabaseConnectionConfiguration {

  public static final String ADAPTER_PROP_PREFIX = "jack.db.adapter";
  public static final String HOST_PROP_PREFIX = "jack.db.host";
  public static final String NAME_PROP_PREFIX = "jack.db.name";
  public static final String PORT_PROP_PREFIX = "jack.db.port";
  public static final String PARALLEL_TEST_PROP_PREFIX = "jack.db.parallel.test";
  public static final String USERNAME_PROP_PREFIX = "jack.db.username";
  public static final String PASSWORD_PROP_PREFIX = "jack.db.password";
  public static final String DATABASE_YML_PROP = "jack.db.database.yml";
  public static final String ENVIRONMENT_YML_PROP = "jack.db.environment.yml";
  private String adapter;
  private String host;
  private String dbName;
  private Optional<Integer> port;
  private Optional<Boolean> parallelTest;
  private Optional<String> username;
  private Optional<String> password;

  public DatabaseConnectionConfiguration(String adapter, String host, String dbName, Optional<Integer> port, Optional<Boolean> parallelTest, Optional<String> username, Optional<String> password) {
    this.adapter = adapter;
    this.host = host;
    this.dbName = dbName;
    this.port = port;
    this.parallelTest = parallelTest;
    this.username = username;
    this.password = password;
  }

  public static DatabaseConnectionConfiguration loadFromEnvironment(String dbNameKey) {
    Map<String, Object> envInfo;
    Map<String, Object> dbInfo;
    // load database info from config folder with highest priority
    // then try working directory, then see if the entire file has been passed
    // as a system property or env var
    envInfo = fetchInfoMap(
        new FileReaderProvider("config/environment.yml"),
        new FileReaderProvider("environment.yml"),
        new PropertyProvider(ENVIRONMENT_YML_PROP),
        new EnvVarProvider(envVar(ENVIRONMENT_YML_PROP)));

    String db_info_name = (String)envInfo.get(dbNameKey);

    dbInfo = fetchInfoMap(
        new FileReaderProvider("config/database.yml"),
        new FileReaderProvider("database.yml"),
        new PropertyProvider(DATABASE_YML_PROP),
        new EnvVarProvider(envVar(DATABASE_YML_PROP)));

    String adapter = load("adapter", dbInfo, "adapter", "database",
        envVar(ADAPTER_PROP_PREFIX, dbNameKey), prop(ADAPTER_PROP_PREFIX, dbNameKey), new StringIdentity());

    String host = load("host", dbInfo, "host", "database",
        envVar(HOST_PROP_PREFIX, dbNameKey), prop(HOST_PROP_PREFIX, dbNameKey), new StringIdentity());

    String dbName = load("database name", dbInfo, "database", "database",
        envVar(NAME_PROP_PREFIX, dbNameKey), prop(NAME_PROP_PREFIX, dbNameKey), new StringIdentity());

    Optional<Integer> port = loadOpt(dbInfo, "port",
        envVar(PORT_PROP_PREFIX, dbNameKey), prop(PORT_PROP_PREFIX, dbNameKey), new ToInteger());

    Optional<Boolean> parallelTesting = loadOpt(envInfo, "enable_parallel_tests",
        envVar(PARALLEL_TEST_PROP_PREFIX, dbNameKey), prop(PARALLEL_TEST_PROP_PREFIX, dbNameKey), new ToBoolean());

    Optional<String> username = loadOpt(dbInfo, "username",
        envVar(USERNAME_PROP_PREFIX, dbNameKey), prop(USERNAME_PROP_PREFIX, dbNameKey), new StringIdentity());

    Optional<String> password = loadOpt(dbInfo, "password",
        envVar(PASSWORD_PROP_PREFIX, dbNameKey), prop(PASSWORD_PROP_PREFIX, dbNameKey), new StringIdentity());

    return new DatabaseConnectionConfiguration(adapter, host, dbName, port, parallelTesting, username, password);
  }

  private static Map<String, Object> fetchInfoMap(ReaderProvider... readers) {
    for (ReaderProvider reader : readers) {
      try {
        return (Map<String, Object>)YAML.load(reader.get());
      } catch (Exception e) {
        //move to next reader
      }
    }
    return Maps.newHashMap();
  }

  private interface ReaderProvider {
    Reader get() throws Exception;
  }

  public static String envVar(String propertyPrefix, String dbNameKey) {
    return propertyPrefix.replace('.', '_').toUpperCase() + "_" + dbNameKey.toUpperCase();
  }

  public static String envVar(String property) {
    return envVar(property, "");
  }

  private static String prop(String baseProp, String dbNameKey) {
    return baseProp + "." + dbNameKey;
  }

  private static <T> T load(
      String readableName,
      Map<String, Object> map,
      String mapKey,
      String mapYmlFile,
      String envVar,
      String javaProp,
      Function<String, T> fromString) {

    Optional<T> result = loadOpt(map, mapKey, envVar, javaProp, fromString);
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new RuntimeException(
          "Unable to find required configuration " + readableName + ". Please set using one of:\n" +
              "Environment Variable: " + envVar + "\n" +
              "Java System Property: " + javaProp + "\n" +
              "Entry in config/" + mapYmlFile + ".yml: " + mapKey);
    }
  }

  private static <T> Optional<T> loadOpt(
      Map<String, Object> map,
      String mapKey,
      String envVar,
      String javaProp,
      Function<String, T> fromString) {
    if (System.getenv(envVar) != null) {
      return Optional.fromNullable(fromString.apply(System.getenv(envVar)));
    }
    if (System.getProperty(javaProp) != null) {
      return Optional.fromNullable(fromString.apply(System.getProperty(javaProp)));
    }
    if (map != null && map.containsKey(mapKey)) {
      return Optional.fromNullable((T)map.get(mapKey));
    }
    return Optional.absent();
  }


  public String getAdapter() {
    return adapter;
  }

  public String getHost() {
    return host;
  }

  public Optional<Integer> getPort() {
    return port;
  }

  public String getDatabaseName() {
    return dbName;
  }

  public Boolean enableParallelTests() {
    return parallelTest.isPresent() ? parallelTest.get() : false;
  }

  public Optional<String> getUsername() {
    return username;
  }

  public Optional<String> getPassword() {
    return password;
  }

  private static class StringIdentity implements Function<String, String> {
    public String apply(String s) {
      return s;
    }
  }

  private static class ToInteger implements Function<String, Integer> {
    public Integer apply(String s) {
      return Integer.parseInt(s);
    }
  }

  private static class ToBoolean implements Function<String, Boolean> {
    public Boolean apply(String s) {
      return Boolean.parseBoolean(s);
    }
  }

  private static class FileReaderProvider implements ReaderProvider {

    private String file;

    public FileReaderProvider(String file) {
      this.file = file;
    }

    @Override
    public InputStreamReader get() throws Exception {
      return new FileReader(file);
    }
  }

  private static class EnvVarProvider implements ReaderProvider {

    private String envVar;

    public EnvVarProvider(String envVar) {
      this.envVar = envVar;
    }

    @Override
    public Reader get() throws Exception {
      if (System.getenv(envVar) != null) {
        return new StringReader(System.getenv(envVar));
      } else {
        throw new IllegalStateException("Env Var " + envVar + " not set");
      }
    }
  }

  private static class PropertyProvider implements ReaderProvider {

    private String property;

    public PropertyProvider(String property) {
      this.property = property;
    }

    @Override
    public Reader get() throws Exception {
      if (System.getProperty(property) != null) {
        return new StringReader(System.getProperty(property));
      } else {
        throw new IllegalStateException("Property " + property + " not set");
      }
    }
  }
}
