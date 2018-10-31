package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.EducationEntity;

import java.util.List;

@Dao
public interface EducationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllEducation(List<EducationEntity> educationEntities);

    @Query("select * from education_table where educationId = :educationId")
    LiveData<EducationEntity> loadEducation(int educationId);

    @Query("select * from education_table where educationId = :educationId")
    EducationEntity loadEducationSync(int educationId);

    @Query("SELECT * FROM education_table")
    LiveData<List<EducationEntity>> loadAllEducation();
}
