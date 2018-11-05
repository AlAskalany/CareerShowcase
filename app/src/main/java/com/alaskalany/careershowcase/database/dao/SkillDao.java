package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.entity.SkillEntity;

import java.util.List;

@Dao
public interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SkillEntity> skillEntities);

    @Query("select * from skills_table where skill_id = :id")
    LiveData<SkillEntity> load(int id);

    @Query("select * from skills_table where skill_id = :id")
    SkillEntity loadSync(int id);

    @Query("SELECT * FROM skills_table")
    LiveData<List<SkillEntity>> loadAll();
}
