package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

import java.util.List;

@Dao
public interface WorkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllWork(List<WorkEntity> workEntities);

    @Query("select * from works_table where workId = :workId")
    LiveData<WorkEntity> loadWork(int workId);

    @Query("select * from works_table where workId = :workId")
    WorkEntity loadWorkSync(int workId);

    @Query("SELECT * FROM works_table")
    LiveData<List<WorkEntity>> loadAllWorks();
}
