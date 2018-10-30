package com.alaskalany.careershowcase.model;

public interface Work
        extends Model {

    int getId();
    String getDescription();
    String getDuration();
    String getCompany();
    String getTitle();
    void setId(int position);
    void setTitle(String title);
    void setDescription(String description);
}
