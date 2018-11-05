package com.alaskalany.careershowcase.entity;

import androidx.room.ColumnInfo;
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
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skill_id")
    private int id;

    /**
     *
     */
    @ColumnInfo(name = "skill_title")
    private String title;

    @ColumnInfo(name = "skill_level")
    private int level;

    @ColumnInfo(name = "skill_log_url")
    private String logoUrl;

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
    public int getId() {

        return id;
    }

    /**
     * @param pSkillId
     */
    @Override
    public void setId(int pSkillId) {

        this.id = pSkillId;
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

    @Override
    public int getLevel() {

        return level;
    }

    @Override
    public void setLevel(int pLevel) {

        level = pLevel;
    }

    @Override
    public String getLogoUrl() {

        return logoUrl;
    }

    @Override
    public void setLogoUrl(String photoUrl) {

        this.logoUrl = photoUrl;
    }
}
