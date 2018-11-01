package com.alaskalany.careershowcase.model;

public interface Work {

    /**
     * @return
     */
    int getWorkId();

    /**
     * @param position
     */
    void setWorkId(int position);

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

    void setCompany(String pCompany);
}
