
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.rapleaf.jack.AssociationType;
import com.rapleaf.jack.AttributesWithId;
import com.rapleaf.jack.BelongsToAssociation;
import com.rapleaf.jack.DefaultAssociationMetadata;
import com.rapleaf.jack.HasManyAssociation;
import com.rapleaf.jack.HasOneAssociation;
import com.rapleaf.jack.IAssociationMetadata;
import com.rapleaf.jack.IModelAssociationMetadata;
import com.rapleaf.jack.ModelIdWrapper;
import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.queries.AbstractTable;
import com.rapleaf.jack.queries.Column;

import com.rapleaf.jack.test_project.IDatabases;
import com.rapleaf.jack.util.JackUtility;

public class TestStore extends ModelWithId<TestStore, IDatabases> implements Comparable<TestStore>{
  
  public static final long serialVersionUID = -7014741754758282419L;

  public static class Tbl extends AbstractTable<TestStore.Attributes, TestStore> {
    public final Column<Long> ID;
    public final Column<Integer> ENTRY_TYPE;
    public final Column<Long> ENTRY_SCOPE;
    public final Column<String> ENTRY_KEY;
    public final Column<String> ENTRY_VALUE;
    public final Column<Long> CREATED_AT;
    public final Column<Long> UPDATED_AT;

    private Tbl(String alias) {
      super("test_store", alias, TestStore.Attributes.class, TestStore.class);
      this.ID = Column.fromId(alias);
      this.ENTRY_TYPE = Column.fromField(alias, _Fields.entry_type, Integer.class);
      this.ENTRY_SCOPE = Column.fromField(alias, _Fields.entry_scope, Long.class);
      this.ENTRY_KEY = Column.fromField(alias, _Fields.entry_key, String.class);
      this.ENTRY_VALUE = Column.fromField(alias, _Fields.entry_value, String.class);
      this.CREATED_AT = Column.fromTimestamp(alias, _Fields.created_at);
      this.UPDATED_AT = Column.fromTimestamp(alias, _Fields.updated_at);
      Collections.addAll(this.allColumns, ID, ENTRY_TYPE, ENTRY_SCOPE, ENTRY_KEY, ENTRY_VALUE, CREATED_AT, UPDATED_AT);
    }

    public static Tbl as(String alias) {
      return new Tbl(alias);
    }
  }

  public static final Tbl TBL = new Tbl("test_store");
  public static final Column<Long> ID = TBL.ID;
  public static final Column<Integer> ENTRY_TYPE = TBL.ENTRY_TYPE;
  public static final Column<Long> ENTRY_SCOPE = TBL.ENTRY_SCOPE;
  public static final Column<String> ENTRY_KEY = TBL.ENTRY_KEY;
  public static final Column<String> ENTRY_VALUE = TBL.ENTRY_VALUE;
  public static final Column<Long> CREATED_AT = TBL.CREATED_AT;
  public static final Column<Long> UPDATED_AT = TBL.UPDATED_AT;

  private final Attributes attributes;

  private transient TestStore.Id cachedTypedId;

  // Associations

  public enum _Fields {
    entry_type,
    entry_scope,
    entry_key,
    entry_value,
    created_at,
    updated_at,
  }

  @Override
  public TestStore.Id getTypedId() {
    if (cachedTypedId == null) {
      cachedTypedId = new TestStore.Id(this.getId());
    }
    return cachedTypedId;
  }

  public TestStore(long id, final Integer entry_type, final Long entry_scope, final String entry_key, final String entry_value, final Long created_at, final Long updated_at, IDatabases databases) {
    super(databases);
    attributes = new Attributes(id, entry_type, entry_scope, entry_key, entry_value, created_at, updated_at);
  }

  public TestStore(long id, final Integer entry_type, final Long entry_scope, final String entry_key, final String entry_value, final Long created_at, final Long updated_at) {
    super(null);
    attributes = new Attributes(id, entry_type, entry_scope, entry_key, entry_value, created_at, updated_at);
  }
  
  public TestStore(long id, IDatabases databases) {
    super(databases);
    attributes = new Attributes(id);
  }

  public TestStore(long id) {
    super(null);
    attributes = new Attributes(id);
  }

  public static TestStore newDefaultInstance(long id) {
    return new TestStore(id);
  }

  public TestStore(Attributes attributes, IDatabases databases) {
    super(databases);
    this.attributes = attributes;

    if (databases != null) {
    }
  }

  public TestStore(Attributes attributes) {
    this(attributes, (IDatabases) null);
  }

  public TestStore(long id, Map<Enum, Object> fieldsMap) {
    super(null);
    attributes = new Attributes(id, fieldsMap);
  }

  public TestStore (TestStore other) {
    this(other, (IDatabases)null);
  }

  public TestStore (TestStore other, IDatabases databases) {
    super(databases);
    attributes = new Attributes(other.getAttributes());

    if (databases != null) {
    }
  }

  public Attributes getAttributes() {
    return attributes;
  }

  public Integer getEntryType() {
    return attributes.getEntryType();
  }

  public TestStore setEntryType(Integer newval) {
    attributes.setEntryType(newval);
    cachedHashCode = 0;
    return this;
  }

  public Long getEntryScope() {
    return attributes.getEntryScope();
  }

  public TestStore setEntryScope(Long newval) {
    attributes.setEntryScope(newval);
    cachedHashCode = 0;
    return this;
  }

  public String getEntryKey() {
    return attributes.getEntryKey();
  }

  public TestStore setEntryKey(String newval) {
    attributes.setEntryKey(newval);
    cachedHashCode = 0;
    return this;
  }

  public String getEntryValue() {
    return attributes.getEntryValue();
  }

  public TestStore setEntryValue(String newval) {
    attributes.setEntryValue(newval);
    cachedHashCode = 0;
    return this;
  }

  public Long getCreatedAt() {
    return attributes.getCreatedAt();
  }

  public TestStore setCreatedAt(Long newval) {
    attributes.setCreatedAt(newval);
    cachedHashCode = 0;
    return this;
  }

  public Long getUpdatedAt() {
    return attributes.getUpdatedAt();
  }

  public TestStore setUpdatedAt(Long newval) {
    attributes.setUpdatedAt(newval);
    cachedHashCode = 0;
    return this;
  }

  public void setField(_Fields field, Object value) {
    switch (field) {
      case entry_type:
        setEntryType((Integer)value);
        break;
      case entry_scope:
        setEntryScope((Long)value);
        break;
      case entry_key:
        setEntryKey((String)value);
        break;
      case entry_value:
        setEntryValue((String)value);
        break;
      case created_at:
        setCreatedAt((Long)value);
        break;
      case updated_at:
        setUpdatedAt((Long)value);
        break;
      default:
        throw new IllegalStateException("Invalid field: " + field);
    }
  }
  
  public void setField(String fieldName, Object value) {
    if (fieldName.equals("entry_type")) {
      setEntryType((Integer)  value);
      return;
    }
    if (fieldName.equals("entry_scope")) {
      setEntryScope((Long)  value);
      return;
    }
    if (fieldName.equals("entry_key")) {
      setEntryKey((String)  value);
      return;
    }
    if (fieldName.equals("entry_value")) {
      setEntryValue((String)  value);
      return;
    }
    if (fieldName.equals("created_at")) {
      setCreatedAt((Long)  value);
      return;
    }
    if (fieldName.equals("updated_at")) {
      setUpdatedAt((Long)  value);
      return;
    }
    throw new IllegalStateException("Invalid field: " + fieldName);
  }

  public static Class getFieldType(_Fields field) {
    switch (field) {
      case entry_type:
        return Integer.class;
      case entry_scope:
        return Long.class;
      case entry_key:
        return String.class;
      case entry_value:
        return String.class;
      case created_at:
        return Long.class;
      case updated_at:
        return Long.class;
      default:
        throw new IllegalStateException("Invalid field: " + field);
    }    
  }

  public static Class getFieldType(String fieldName) {    
    if (fieldName.equals("entry_type")) {
      return Integer.class;
    }
    if (fieldName.equals("entry_scope")) {
      return Long.class;
    }
    if (fieldName.equals("entry_key")) {
      return String.class;
    }
    if (fieldName.equals("entry_value")) {
      return String.class;
    }
    if (fieldName.equals("created_at")) {
      return Long.class;
    }
    if (fieldName.equals("updated_at")) {
      return Long.class;
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  @Override
  public Object getField(String fieldName) {
    if (fieldName.equals("id")) {
      return getId();
    }
    if (fieldName.equals("entry_type")) {
      return getEntryType();
    }
    if (fieldName.equals("entry_scope")) {
      return getEntryScope();
    }
    if (fieldName.equals("entry_key")) {
      return getEntryKey();
    }
    if (fieldName.equals("entry_value")) {
      return getEntryValue();
    }
    if (fieldName.equals("created_at")) {
      return getCreatedAt();
    }
    if (fieldName.equals("updated_at")) {
      return getUpdatedAt();
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  public Object getField(_Fields field) {
    switch (field) {
      case entry_type:
        return getEntryType();
      case entry_scope:
        return getEntryScope();
      case entry_key:
        return getEntryKey();
      case entry_value:
        return getEntryValue();
      case created_at:
        return getCreatedAt();
      case updated_at:
        return getUpdatedAt();
    }
    throw new IllegalStateException("Invalid field: " + field);
  }

  public boolean hasField(String fieldName) {
    if (fieldName.equals("id")) {
      return true;
    }
    if (fieldName.equals("entry_type")) {
      return true;
    }
    if (fieldName.equals("entry_scope")) {
      return true;
    }
    if (fieldName.equals("entry_key")) {
      return true;
    }
    if (fieldName.equals("entry_value")) {
      return true;
    }
    if (fieldName.equals("created_at")) {
      return true;
    }
    if (fieldName.equals("updated_at")) {
      return true;
    }
    return false;
  }

  public static Object getDefaultValue(_Fields field) {
    switch (field) {
      case entry_type:
        return null;
      case entry_scope:
        return null;
      case entry_key:
        return null;
      case entry_value:
        return null;
      case created_at:
        return null;
      case updated_at:
        return null;
    }
    throw new IllegalStateException("Invalid field: " + field);
  }

  @Override
  public Set<Enum> getFieldSet() {
    Set set = EnumSet.allOf(_Fields.class);
    return set;
  }

  @Override
  public TestStore getCopy() {
    return getCopy(databases);
  }

  @Override
  public TestStore getCopy(IDatabases databases) {
    return new TestStore(this, databases);
  }

  @Override
  public boolean save() throws IOException {
    return databases.getDatabase1().testStore().save(this);
  }

  public String toString() {
    return "<TestStore"
        + " id: " + this.getId()
        + " entry_type: " + getEntryType()
        + " entry_scope: " + getEntryScope()
        + " entry_key: " + getEntryKey()
        + " entry_value: " + getEntryValue()
        + " created_at: " + getCreatedAt()
        + " updated_at: " + getUpdatedAt()
        + ">";
  }

  public void unsetAssociations() {
    unsetDatabaseReference();
  }

  public int compareTo(TestStore that) {
    return Long.valueOf(this.getId()).compareTo(that.getId());
  }
  
  
  public static class Attributes extends AttributesWithId {
    
    public static final long serialVersionUID = -7014741754758282419L;

    // Fields
    private Integer __entry_type;
    private Long __entry_scope;
    private String __entry_key;
    private String __entry_value;
    private Long __created_at;
    private Long __updated_at;

    public Attributes(long id) {
      super(id);
    }

    public Attributes(long id, final Integer entry_type, final Long entry_scope, final String entry_key, final String entry_value, final Long created_at, final Long updated_at) {
      super(id);
      this.__entry_type = entry_type;
      this.__entry_scope = entry_scope;
      this.__entry_key = entry_key;
      this.__entry_value = entry_value;
      this.__created_at = created_at;
      this.__updated_at = updated_at;
    }

    public static Attributes newDefaultInstance(long id) {
      return new Attributes(id);
    }

    public Attributes(long id, Map<Enum, Object> fieldsMap) {
      super(id);
      Integer entry_type = (Integer)fieldsMap.get(TestStore._Fields.entry_type);
      Long entry_scope = (Long)fieldsMap.get(TestStore._Fields.entry_scope);
      String entry_key = (String)fieldsMap.get(TestStore._Fields.entry_key);
      String entry_value = (String)fieldsMap.get(TestStore._Fields.entry_value);
      Long created_at = (Long)fieldsMap.get(TestStore._Fields.created_at);
      Long updated_at = (Long)fieldsMap.get(TestStore._Fields.updated_at);
      this.__entry_type = entry_type;
      this.__entry_scope = entry_scope;
      this.__entry_key = entry_key;
      this.__entry_value = entry_value;
      this.__created_at = created_at;
      this.__updated_at = updated_at;
    }

    public Attributes(Attributes other) {
      super(other.getId());
      this.__entry_type = other.getEntryType();
      this.__entry_scope = other.getEntryScope();
      this.__entry_key = other.getEntryKey();
      this.__entry_value = other.getEntryValue();
      this.__created_at = other.getCreatedAt();
      this.__updated_at = other.getUpdatedAt();
    }

    public Integer getEntryType() {
      return __entry_type;
    }

    public Attributes setEntryType(Integer newval) {
      this.__entry_type = newval;
      cachedHashCode = 0;
      return this;
    }

    public Long getEntryScope() {
      return __entry_scope;
    }

    public Attributes setEntryScope(Long newval) {
      this.__entry_scope = newval;
      cachedHashCode = 0;
      return this;
    }

    public String getEntryKey() {
      return __entry_key;
    }

    public Attributes setEntryKey(String newval) {
      this.__entry_key = newval;
      cachedHashCode = 0;
      return this;
    }

    public String getEntryValue() {
      return __entry_value;
    }

    public Attributes setEntryValue(String newval) {
      this.__entry_value = newval;
      cachedHashCode = 0;
      return this;
    }

    public Long getCreatedAt() {
      return __created_at;
    }

    public Attributes setCreatedAt(Long newval) {
      this.__created_at = newval;
      cachedHashCode = 0;
      return this;
    }

    public Long getUpdatedAt() {
      return __updated_at;
    }

    public Attributes setUpdatedAt(Long newval) {
      this.__updated_at = newval;
      cachedHashCode = 0;
      return this;
    }

    public void setField(_Fields field, Object value) {
      switch (field) {
        case entry_type:
          setEntryType((Integer)value);
          break;
        case entry_scope:
          setEntryScope((Long)value);
          break;
        case entry_key:
          setEntryKey((String)value);
          break;
        case entry_value:
          setEntryValue((String)value);
          break;
        case created_at:
          setCreatedAt((Long)value);
          break;
        case updated_at:
          setUpdatedAt((Long)value);
          break;
        default:
          throw new IllegalStateException("Invalid field: " + field);
      }
    }

    public void setField(String fieldName, Object value) {
      if (fieldName.equals("entry_type")) {
        setEntryType((Integer)value);
        return;
      }
      if (fieldName.equals("entry_scope")) {
        setEntryScope((Long)value);
        return;
      }
      if (fieldName.equals("entry_key")) {
        setEntryKey((String)value);
        return;
      }
      if (fieldName.equals("entry_value")) {
        setEntryValue((String)value);
        return;
      }
      if (fieldName.equals("created_at")) {
        setCreatedAt((Long)value);
        return;
      }
      if (fieldName.equals("updated_at")) {
        setUpdatedAt((Long)value);
        return;
      }
      throw new IllegalStateException("Invalid field: " + fieldName);
    }

    public static Class getFieldType(_Fields field) {
      switch (field) {
        case entry_type:
          return Integer.class;
        case entry_scope:
          return Long.class;
        case entry_key:
          return String.class;
        case entry_value:
          return String.class;
        case created_at:
          return Long.class;
        case updated_at:
          return Long.class;
        default:
          throw new IllegalStateException("Invalid field: " + field);
      }    
    }

    public static Class getFieldType(String fieldName) {    
      if (fieldName.equals("entry_type")) {
        return Integer.class;
      }
      if (fieldName.equals("entry_scope")) {
        return Long.class;
      }
      if (fieldName.equals("entry_key")) {
        return String.class;
      }
      if (fieldName.equals("entry_value")) {
        return String.class;
      }
      if (fieldName.equals("created_at")) {
        return Long.class;
      }
      if (fieldName.equals("updated_at")) {
        return Long.class;
      }
      throw new IllegalStateException("Invalid field name: " + fieldName);
    }

    @Override
    public Object getField(String fieldName) {
      if (fieldName.equals("id")) {
        return getId();
      }
      if (fieldName.equals("entry_type")) {
        return getEntryType();
      }
      if (fieldName.equals("entry_scope")) {
        return getEntryScope();
      }
      if (fieldName.equals("entry_key")) {
        return getEntryKey();
      }
      if (fieldName.equals("entry_value")) {
        return getEntryValue();
      }
      if (fieldName.equals("created_at")) {
        return getCreatedAt();
      }
      if (fieldName.equals("updated_at")) {
        return getUpdatedAt();
      }
      throw new IllegalStateException("Invalid field name: " + fieldName);
    }

    public Object getField(_Fields field) {
      switch (field) {
        case entry_type:
          return getEntryType();
        case entry_scope:
          return getEntryScope();
        case entry_key:
          return getEntryKey();
        case entry_value:
          return getEntryValue();
        case created_at:
          return getCreatedAt();
        case updated_at:
          return getUpdatedAt();
      }
      throw new IllegalStateException("Invalid field: " + field);
    }

    public boolean hasField(String fieldName) {
      if (fieldName.equals("id")) {
        return true;
      }
      if (fieldName.equals("entry_type")) {
        return true;
      }
      if (fieldName.equals("entry_scope")) {
        return true;
      }
      if (fieldName.equals("entry_key")) {
        return true;
      }
      if (fieldName.equals("entry_value")) {
        return true;
      }
      if (fieldName.equals("created_at")) {
        return true;
      }
      if (fieldName.equals("updated_at")) {
        return true;
      }
      return false;
    }

    public static Object getDefaultValue(_Fields field) {
      switch (field) {
        case entry_type:
          return null;
        case entry_scope:
          return null;
        case entry_key:
          return null;
        case entry_value:
          return null;
        case created_at:
          return null;
        case updated_at:
          return null;
      }
      throw new IllegalStateException("Invalid field: " + field);
    }
    
    @Override
    public Set<Enum> getFieldSet() {
      Set set = EnumSet.allOf(_Fields.class);
      return set;
    }
    
    public String toString() {
      return "<TestStore.Attributes"
          + " entry_type: " + getEntryType()
          + " entry_scope: " + getEntryScope()
          + " entry_key: " + getEntryKey()
          + " entry_value: " + getEntryValue()
          + " created_at: " + getCreatedAt()
          + " updated_at: " + getUpdatedAt()
          + ">";
    }
  }

  public static class Id implements ModelIdWrapper<TestStore.Id> {
    public static final long serialVersionUID = 1L;

    private final long id;

    public Id(Long id) {
      this.id = id;
    }

    @Override
    public Long getId() {
      return id;
    }

    @Override
    public int compareTo(Id other) {
      return this.getId().compareTo(other.getId());
    }

    @Override
    public boolean equals(Object other) {
      if (other instanceof Id) {
        return this.getId().equals(((Id)other).getId());
      }
      return false;
    }

    @Override
    public int hashCode() {
      return this.getId().hashCode();
    }

    @Override
    public String toString() {
      return "<TestStore.Id: " + this.getId() + ">";
    }
  }

  public static Set<Attributes> convertToAttributesSet(Collection<TestStore> models) {
    return models.stream()
        .map(TestStore::getAttributes)
        .collect(Collectors.toSet());
  }

  public static class AssociationMetadata implements IModelAssociationMetadata {

    private List<IAssociationMetadata> meta = new ArrayList<>();

    public AssociationMetadata(){
    }

    @Override
    public List<IAssociationMetadata> getAssociationMetadata() {
      return meta;
    }
  }

}
