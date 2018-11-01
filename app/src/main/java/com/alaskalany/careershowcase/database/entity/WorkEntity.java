package com.alaskalany.careershowcase.database.entity;

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
    private int workId;

    @ColumnInfo(name = "work_title")
    private String title;

    @ColumnInfo(name = "work_description")
    private String description;

    @ColumnInfo(name = "work_company")
    private String company;

    public WorkEntity() {

    }

    @Override
    public int getWorkId() {

        return workId;
    }

    @Override
    public void setWorkId(int workId) {

        this.workId = workId;
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

        return null;
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
    public void setCompany(String pCompany) {

        company = pCompany;
    }
}
