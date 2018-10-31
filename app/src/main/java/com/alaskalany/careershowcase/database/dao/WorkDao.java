package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

import java.util.List;

@Dao
public interface WorkDao
        extends BaseDao<WorkEntity> {

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<WorkEntity> workEntities);

    @Override
    @Query("select * from works_table where workId = :workId")
    LiveData<WorkEntity> load(int workId);

    @Override
    @Query("select * from works_table where workId = :workId")
    WorkEntity loadSync(int workId);

    @Override
    @Query("SELECT * FROM works_table")
    LiveData<List<WorkEntity>> loadAll();
}
