package com.proyectofinal;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAO_Impl implements DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Entity> __insertionAdapterOfEntity;

  private final EntityDeletionOrUpdateAdapter<Entity> __deletionAdapterOfEntity;

  private final EntityDeletionOrUpdateAdapter<Entity> __updateAdapterOfEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntity = new EntityInsertionAdapter<Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `To_Do` (`id`,`title`,`priority`,`dni`,`placa`,`name`,`phone`,`hora`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getPriority() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPriority());
        }
        if (value.getDni() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDni());
        }
        if (value.getPlaca() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPlaca());
        }
        if (value.getName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getHora() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getHora());
        }
      }
    };
    this.__deletionAdapterOfEntity = new EntityDeletionOrUpdateAdapter<Entity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `To_Do` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfEntity = new EntityDeletionOrUpdateAdapter<Entity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `To_Do` SET `id` = ?,`title` = ?,`priority` = ?,`dni` = ?,`placa` = ?,`name` = ?,`phone` = ?,`hora` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getPriority() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPriority());
        }
        if (value.getDni() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDni());
        }
        if (value.getPlaca() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPlaca());
        }
        if (value.getName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getHora() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getHora());
        }
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from to_do";
        return _query;
      }
    };
  }

  @Override
  public void insertTask(final Entity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(final Entity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(final Entity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEntity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<CardInfo> getTasks() {
    final String _sql = "Select * from to_do";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
      final int _cursorIndexOfDni = CursorUtil.getColumnIndexOrThrow(_cursor, "dni");
      final int _cursorIndexOfPlaca = CursorUtil.getColumnIndexOrThrow(_cursor, "placa");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
      final List<CardInfo> _result = new ArrayList<CardInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CardInfo _item;
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpPriority;
        if (_cursor.isNull(_cursorIndexOfPriority)) {
          _tmpPriority = null;
        } else {
          _tmpPriority = _cursor.getString(_cursorIndexOfPriority);
        }
        final String _tmpDni;
        if (_cursor.isNull(_cursorIndexOfDni)) {
          _tmpDni = null;
        } else {
          _tmpDni = _cursor.getString(_cursorIndexOfDni);
        }
        final String _tmpPlaca;
        if (_cursor.isNull(_cursorIndexOfPlaca)) {
          _tmpPlaca = null;
        } else {
          _tmpPlaca = _cursor.getString(_cursorIndexOfPlaca);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpHora;
        if (_cursor.isNull(_cursorIndexOfHora)) {
          _tmpHora = null;
        } else {
          _tmpHora = _cursor.getString(_cursorIndexOfHora);
        }
        _item = new CardInfo(_tmpTitle,_tmpPriority,_tmpDni,_tmpPlaca,_tmpName,_tmpPhone,_tmpHora);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
