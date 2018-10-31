package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.alaskalany.careershowcase.database.entity.SkillEntity;

import java.util.List;

@Dao
public interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllSkills(List<SkillEntity> skillEntities);

    @Query("select * from skills_table where skillId = :skillId")
    LiveData<SkillEntity> loadSkill(int skillId);

    @Query("select * from skills_table where skillId = :skillId")
    SkillEntity loadSkillSync(int skillId);

    @Query("SELECT * FROM skills_table")
    LiveData<List<SkillEntity>> loadAllSkills();
}
