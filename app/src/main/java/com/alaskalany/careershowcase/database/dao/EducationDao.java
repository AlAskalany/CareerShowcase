package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.EducationEntity;

import java.util.List;

@Dao
public interface EducationDao
        extends BaseDao<EducationEntity> {

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EducationEntity> educationEntities);

    @Override
    @Query("select * from education_table where educationId = :educationId")
    LiveData<EducationEntity> load(int educationId);

    @Override
    @Query("select * from education_table where educationId = :educationId")
    EducationEntity loadSync(int educationId);

    @Override
    @Query("SELECT * FROM education_table")
    LiveData<List<EducationEntity>> loadAll();
}
