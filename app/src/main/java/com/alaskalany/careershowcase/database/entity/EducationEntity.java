package com.alaskalany.careershowcase.database.entity;

import androidx.room.*;
import com.alaskalany.careershowcase.model.Education;

/**
 * A education item representing a piece of description.
 */
@Entity(tableName = "education", indices = {@Index(value = {"title"}, unique = true)})
public class EducationEntity
        implements Education {

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
    @Embedded
    private String school;
    /**
     *
     */
    @ColumnInfo(name = "degree")
    private String degree;
    /**
     *
     */
    @ColumnInfo(name = "study_field")
    private String studyField;
    /**
     *
     */
    @ColumnInfo(name = "description")
    private String description;
    /**
     *
     */
    @ColumnInfo(name = "duration")
    private String duration;

    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public EducationEntity() {

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
    @Override
    public void setId(int id) {

        this.id = id;
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
    public String getSchool() {

        return school;
    }

    /**
     * @param school
     */
    @Override
    public void setSchool(String school) {

        this.school = school;
    }

    /**
     * @return
     */
    @Override
    public String getDegree() {

        return degree;
    }

    /**
     * @param degree
     */
    @Override
    public void setDegree(String degree) {

        this.degree = degree;
    }

    /**
     * @return
     */
    @Override
    public String getStudyField() {

        return studyField;
    }

    /**
     * @param studyField
     */
    @Override
    public void setStudyField(String studyField) {

        this.studyField = studyField;
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
    @Override
    public String getDuration() {

        return duration;
    }

    /**
     * @param duration
     */
    @Override
    public void setDuration(String duration) {

        this.duration = duration;
    }
}
