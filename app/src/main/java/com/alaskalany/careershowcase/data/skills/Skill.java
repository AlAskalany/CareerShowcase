package com.alaskalany.careershowcase.data.skills;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A skill item representing a piece of description.
 */
@Entity
public class Skill {

    @PrimaryKey
    @SuppressWarnings("WeakerAccess")
    public int id;
    @SuppressWarnings("WeakerAccess")
    public String title;
    @SuppressWarnings("WeakerAccess")
    public String description;

    @SuppressWarnings("WeakerAccess")
    public Skill() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {

        return title;
    }
}
