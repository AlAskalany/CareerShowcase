package com.alaskalany.careershowcase.model;

public interface Work
        extends Model {

    /**
     * @return
     */
    int getId();
    /**
     * @param position
     */
    void setId(int position);
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
     * @return
     */
    String getCompany();
    /**
     * @return
     */
    String getTitle();
    /**
     * @param title
     */
    void setTitle(String title);
}
