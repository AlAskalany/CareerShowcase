package com.alaskalany.careershowcase.model;

/**
 *
 */
public interface Education {

    /**
     * @return
     */
    int getEducationId();

    /**
     * @param id
     */
    void setEducationId(int id);

    String getEducationTitle();

    void setEducationTitle(String educationTitle);

    String getEducationDegree();

    void setEducationDegree(String educationDegree);

    String getEducationStudyField();

    void setEducationStudyField(String educationStudyField);

    String getEducationDescription();

    void setEducationDescription(String educationDescription);
}
