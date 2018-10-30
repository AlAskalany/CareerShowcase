package com.alaskalany.careershowcase.model;

import com.alaskalany.careershowcase.data.common.Duration;
import com.alaskalany.careershowcase.data.common.School;

public interface Education {

    int getId();
    void setId(int id);
    String getTitle();
    void setTitle(String title);
    School getSchool();
    void setSchool(School school);
    String getDegree();
    void setDegree(String degree);
    String getStudyField();
    void setStudyField(String studyField);
    String getDescription();
    void setDescription(String description);
    Duration getDuration();
    void setDuration(Duration duration);
}
