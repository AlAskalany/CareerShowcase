package com.alaskalany.careershowcase.data.education;

import androidx.room.*;
import com.alaskalany.careershowcase.data.common.Duration;
import com.alaskalany.careershowcase.data.common.School;

/**
 * A education item representing a piece of description.
 */
@Entity(tableName = "education", indices = {@Index(value = {"title"}, unique = true)})
public class Education {

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
    public Education() {

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

    public School getSchool() {

        return school;
    }

    public void setSchool(School school) {

        this.school = school;
    }

    public String getDegree() {

        return degree;
    }

    public void setDegree(String degree) {

        this.degree = degree;
    }

    public String getStudyField() {

        return studyField;
    }

    public void setStudyField(String studyField) {

        this.studyField = studyField;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Duration getDuration() {

        return duration;
    }

    public void setDuration(Duration duration) {

        this.duration = duration;
    }
}
