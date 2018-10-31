package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.ContactEntity;

import java.util.List;

@Dao
public interface ContactDao
        extends BaseDao<ContactEntity> {

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ContactEntity> contactEntities);

    @Override
    @Query("select * from contacts_table where contactId = :contactId")
    LiveData<ContactEntity> load(int contactId);

    @Override
    @Query("select * from contacts_table where contactId = :contactId")
    ContactEntity loadSync(int contactId);

    @Override
    @Query("SELECT * FROM contacts_table")
    LiveData<List<ContactEntity>> loadAll();
}
