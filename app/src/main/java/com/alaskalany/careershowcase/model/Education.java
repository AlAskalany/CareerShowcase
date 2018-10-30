package com.alaskalany.careershowcase.model;

/**
 *
 */
public interface Education
        extends Model {

    /**
     * @return
     */
    int getId();
    /**
     * @param id
     */
    void setId(int id);
    /**
     * @return
     */
    String getTitle();
    /**
     * @param title
     */
    void setTitle(String title);
    /**
     * @return
     */
    String getSchool();
    /**
     * @param school
     */
    void setSchool(String school);
    /**
     * @return
     */
    String getDegree();
    void setDegree(String degree);
    /**
     * @return
     */
    String getStudyField();
    /**
     * @param studyField
     */
    void setStudyField(String studyField);
    /**
     * @return
     */
    String getDescription();
    /**
     * @param description
     */
    void setDescription(String description);
    /**
     * @return
     */
    String getDuration();
    /**
     * @param duration
     */
    void setDuration(String duration);
}
