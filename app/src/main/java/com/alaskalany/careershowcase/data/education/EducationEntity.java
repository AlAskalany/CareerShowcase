package com.alaskalany.careershowcase.data.education;

import androidx.room.*;
import com.alaskalany.careershowcase.data.common.Duration;
import com.alaskalany.careershowcase.data.common.School;
import com.alaskalany.careershowcase.model.Education;

/**
 * A education item representing a piece of description.
 */
@Entity(tableName = "education", indices = {@Index(value = {"title"}, unique = true)})
public class EducationEntity
        implements Education {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @Embedded
    private School school;
    @ColumnInfo(name = "degree")
    private String degree;
    @ColumnInfo(name = "study_field")
    private String studyField;
    @ColumnInfo(name = "description")
    private String description;
    @Embedded
    private Duration duration;

    @SuppressWarnings("WeakerAccess")
    public EducationEntity() {

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
    public School getSchool() {

        return school;
    }

    @Override
    public void setSchool(School school) {

        this.school = school;
    }

    @Override
    public String getDegree() {

        return degree;
    }

    @Override
    public void setDegree(String degree) {

        this.degree = degree;
    }

    @Override
    public String getStudyField() {

        return studyField;
    }

    @Override
    public void setStudyField(String studyField) {

        this.studyField = studyField;
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
    public Duration getDuration() {

        return duration;
    }

    @Override
    public void setDuration(Duration duration) {

        this.duration = duration;
    }
}
