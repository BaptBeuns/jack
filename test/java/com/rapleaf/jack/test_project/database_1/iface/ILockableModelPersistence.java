
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.iface;

import com.rapleaf.jack.test_project.database_1.models.LockableModel;
import com.rapleaf.jack.test_project.database_1.query.LockableModelQueryBuilder;
import com.rapleaf.jack.test_project.database_1.query.LockableModelDeleteBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import com.rapleaf.jack.IModelPersistence;

public interface ILockableModelPersistence extends IModelPersistence<LockableModel> {
  public LockableModel create(final int lock_version, final String message, final long created_at, final long updated_at) throws IOException;
  public LockableModel create(final int lock_version, final long created_at, final long updated_at) throws IOException;

  public LockableModel createDefaultInstance() throws IOException;
  public List<LockableModel> findByLockVersion(int value)  throws IOException;
  public List<LockableModel> findByMessage(String value)  throws IOException;
  public List<LockableModel> findByCreatedAt(long value)  throws IOException;
  public List<LockableModel> findByUpdatedAt(long value)  throws IOException;

  public LockableModelQueryBuilder query();

  public LockableModelDeleteBuilder delete();
}