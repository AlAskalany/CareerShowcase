package com.alaskalany.careershowcase.data.skills;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Skill;

/**
 * A skill item representing a piece of description.
 */
@Entity
public class SkillEntity
        implements Skill {

    @PrimaryKey
    @SuppressWarnings("WeakerAccess")
    public int id;
    @SuppressWarnings("WeakerAccess")
    public String title;
    @SuppressWarnings("WeakerAccess")
    public String description;

    @SuppressWarnings("WeakerAccess")
    public SkillEntity() {

    }

    @Override
    public int getId() {

        return id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    @Override
    public String getTitle() {

        return title;
    }

    @Override
    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public String getDescription() {

        return description;
    }

    @Override
    public void setDescription(String description) {

        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {

        return title;
    }
}