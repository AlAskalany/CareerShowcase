package com.alaskalany.careershowcase.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Education;

/**
 * A education item representing a piece of educationDescription.
 */
@Entity(tableName = "education_table")
public class EducationEntity
        implements Education {

    @PrimaryKey(autoGenerate = true)
    private int educationId;

    @ColumnInfo(name = "educationTitle")
    private String educationTitle;

    @ColumnInfo(name = "educationDegree")
    private String educationDegree;

    @ColumnInfo(name = "study_field")
    private String educationStudyField;

    @ColumnInfo(name = "educationDescription")
    private String educationDescription;

    public EducationEntity() {

    }

    @Override
    public int getEducationId() {

        return educationId;
    }

    @Override
    public void setEducationId(int educationId) {

        this.educationId = educationId;
    }

    @Override
    public String getEducationTitle() {

        return educationTitle;
    }

    @Override
    public void setEducationTitle(String educationTitle) {

        this.educationTitle = educationTitle;
    }

    @Override
    public String getEducationDegree() {

        return educationDegree;
    }

    @Override
    public void setEducationDegree(String educationDegree) {

        this.educationDegree = educationDegree;
    }

    @Override
    public String getEducationStudyField() {

        return educationStudyField;
    }

    @Override
    public void setEducationStudyField(String educationStudyField) {

        this.educationStudyField = educationStudyField;
    }

    @Override
    public String getEducationDescription() {

        return educationDescription;
    }

    @Override
    public void setEducationDescription(String educationDescription) {

        this.educationDescription = educationDescription;
    }
}
