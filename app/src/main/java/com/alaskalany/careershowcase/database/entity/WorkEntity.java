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

    /**
     *
     */
    @PrimaryKey
    private int id;
    /**
     *
     */
    @ColumnInfo(name = "title")
    private String title;
    /**
     *
     */
    @ColumnInfo(name = "description")
    private String description;
    /**
     *
     */
    @ColumnInfo(name = "company")
    private String company;
    /**
     *
     */
    @ColumnInfo(name = "duration")
    private String duration;

    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public WorkEntity() {

    }

    /**
     * @return
     */
    @Override
    public int getId() {

        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {

        this.id = id;
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
    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * @return
     */
    @Override
    public String getDuration() {

        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(String duration) {

        this.duration = duration;
    }

    /**
     * @return
     */
    @Override
    public String getCompany() {

        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {

        this.company = company;
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
    public void setTitle(String title) {

        this.title = title;
    }

    /**
     * @return
     */
    @NonNull
    @Override
    public String toString() {

        return description;
    }
}
