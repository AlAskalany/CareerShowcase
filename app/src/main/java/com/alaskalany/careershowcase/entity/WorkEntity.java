package com.alaskalany.careershowcase.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Work;

/**
 * A contact item representing a piece of description.
 */
@Entity(tableName = "works_table")
public class WorkEntity
        implements Work {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "work_id")
    private int id;

    @ColumnInfo(name = "work_title")
    private String title;

    @ColumnInfo(name = "work_description")
    private String description;

    @ColumnInfo(name = "work_company")
    private String company;

    @ColumnInfo(name = "work_location")
    private String location;

    @ColumnInfo(name = "work_duration")
    private String duration;

    public WorkEntity() {

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
    public String getDescription() {

        return description;
    }

    @Override
    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String getDuration() {

        return duration;
    }

    @Override
    public String getCompany() {

        return company;
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
    public void setCompany(String company) {

        this.company = company;
    }

    @Override
    public String getLocation() {

        return location;
    }

    @Override
    public void setLocation(String location) {

        this.location = location;
    }

    @Override
    public void setDuration(String duration) {

        this.duration = duration;
    }
}
