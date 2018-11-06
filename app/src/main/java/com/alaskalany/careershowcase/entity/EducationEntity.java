/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Education;

/**
 * A education item representing a piece of description.
 */
@Entity(tableName = "education_table")
public class EducationEntity
        implements Education {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "education_id")
    private int id;

    @ColumnInfo(name = "education_title")
    private String title;

    @ColumnInfo(name = "education_degree")
    private String degree;

    @ColumnInfo(name = "study_field")
    private String studyField;

    @ColumnInfo(name = "education_description")
    private String description;

    @ColumnInfo(name = "education_institution")
    private String institution;

    @ColumnInfo(name = "education_location")
    private String location;

    @ColumnInfo(name = "education_duration")
    private String duration;

    @ColumnInfo(name = "education_logo_url")
    private String logoUrl;

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
    public String getInstitution() {

        return institution;
    }

    @Override
    public void setInstitution(String pEducationInstitution) {

        institution = pEducationInstitution;
    }

    @Override
    public String getLocation() {

        return location;
    }

    @Override
    public void setLocation(String pEducationLocation) {

        location = pEducationLocation;
    }

    @Override
    public String getDuration() {

        return duration;
    }

    @Override
    public void setDuration(String pEducationDuration) {

        duration = pEducationDuration;
    }

    @Override
    public String getLogoUrl() {

        return logoUrl;
    }

    @Override
    public void setLogoUrl(String logoUrl) {

        this.logoUrl = logoUrl;
    }
}
