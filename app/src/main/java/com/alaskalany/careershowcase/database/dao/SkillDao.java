package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.SkillEntity;

import java.util.List;

@Dao
public interface SkillDao
        extends BaseDao<SkillEntity> {

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SkillEntity> skillEntities);

    @Override
    @Query("select * from skills_table where skillId = :skillId")
    LiveData<SkillEntity> load(int skillId);

    @Override
    @Query("select * from skills_table where skillId = :skillId")
    SkillEntity loadSync(int skillId);

    @Override
    @Query("SELECT * FROM skills_table")
    LiveData<List<SkillEntity>> loadAll();
}
