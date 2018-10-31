package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.ContactEntity;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllContacts(List<ContactEntity> contactEntities);

    @Query("select * from contacts_table where contactId = :contactId")
    LiveData<ContactEntity> loadContact(int contactId);

    @Query("select * from contacts_table where contactId = :contactId")
    ContactEntity loadContactSync(int contactId);

    @Query("SELECT * FROM contacts_table")
    LiveData<List<ContactEntity>> loadAllContacts();
}
