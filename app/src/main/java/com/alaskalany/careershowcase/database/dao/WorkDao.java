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
    void insertAll(List<WorkEntity> workEntities);

    @Query("select * from works_table where work_id = :workId")
    LiveData<WorkEntity> load(int workId);

    @Query("select * from works_table where work_id = :workId")
    WorkEntity loadSync(int workId);

    @Query("SELECT * FROM works_table")
    LiveData<List<WorkEntity>> loadAll();
}
