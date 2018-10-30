package com.alaskalany.careershowcase.data.work;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.data.common.Company;
import com.alaskalany.careershowcase.data.common.Duration;
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
    @Embedded
    private Company company;
    @Embedded
    private Duration duration;

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
    public Duration getDuration() {

        return duration;
    }

    public void setDuration(Duration duration) {

        this.duration = duration;
    }

    @Override
    public Company getCompany() {

        return company;
    }

    public void setCompany(Company company) {

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
