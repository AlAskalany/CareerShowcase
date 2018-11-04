package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.entity.EducationEntity;

import java.util.List;

@Dao
public interface EducationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EducationEntity> educationEntities);

    @Query("select * from education_table where education_id = :id")
    LiveData<EducationEntity> load(int id);

    @Query("select * from education_table where education_id = :id")
    EducationEntity loadSync(int id);

    @Query("SELECT * FROM education_table")
    LiveData<List<EducationEntity>> loadAll();
}
