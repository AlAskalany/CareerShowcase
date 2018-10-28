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
    public String label;
    @SuppressWarnings("WeakerAccess")
    public String details;

    @SuppressWarnings("WeakerAccess")
    public Skill() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLabel() {

        return label;
    }

    public void setLabel(String label) {

        this.label = label;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {

        this.details = details;
    }

    @NonNull
    @Override
    public String toString() {

        return label;
    }
}
