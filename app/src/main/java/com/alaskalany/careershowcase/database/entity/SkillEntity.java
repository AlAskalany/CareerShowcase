package com.alaskalany.careershowcase.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Skill;

/**
 * A skill item representing a piece of description.
 */
@Entity(tableName = "skills_table")
public class SkillEntity
        implements Skill {

    /**
     *
     */
    @PrimaryKey
    @SuppressWarnings("WeakerAccess")
    public int skillId;

    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public String title;

    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public String description;

    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public SkillEntity() {

    }

    /**
     * @return
     */
    @Override
    public int getSkillId() {

        return skillId;
    }

    /**
     * @param pSkillId
     */
    @Override
    public void setSkillId(int pSkillId) {

        this.skillId = pSkillId;
    }

    /**
     * @return
     */
    @Override
    public String getTitle() {

        return title;
    }

    /**
     * @param title
     */
    @Override
    public void setTitle(String title) {

        this.title = title;
    }

    /**
     * @return
     */
    @Override
    public String getDescription() {

        return description;
    }

    /**
     * @param description
     */
    @Override
    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * @return
     */
    @NonNull
    @Override
    public String toString() {

        return title;
    }
}
