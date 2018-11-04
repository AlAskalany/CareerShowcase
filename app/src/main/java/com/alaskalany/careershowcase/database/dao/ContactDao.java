package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.entity.ContactEntity;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ContactEntity> contactEntities);

    @Query("select * from contacts_table where contact_id = :id")
    LiveData<ContactEntity> load(int id);

    @Query("select * from contacts_table where contact_id = :id")
    ContactEntity loadSync(int id);

    @Query("SELECT * FROM contacts_table")
    LiveData<List<ContactEntity>> loadAll();
}
