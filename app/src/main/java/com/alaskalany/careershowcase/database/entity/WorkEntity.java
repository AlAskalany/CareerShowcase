package com.alaskalany.careershowcase.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Work;

/**
 * A work item representing a piece of description.
 */
@Entity
public class WorkEntity
        implements Work {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "company")
    private String company;
    @ColumnInfo(name = "duration")
    private String duration;

    @SuppressWarnings("WeakerAccess")
    public WorkEntity() {

    }

    @Override
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Override
    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String getDuration() {

        return duration;
    }

    public void setDuration(String duration) {

        this.duration = duration;
    }

    @Override
    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    @NonNull
    @Override
    public String toString() {

        return description;
    }

    @Override
    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
