package com.alaskalany.careershowcase.model;

import com.alaskalany.careershowcase.data.common.Company;
import com.alaskalany.careershowcase.data.common.Duration;

public interface Work {

    int getId();
    String getDescription();
    Duration getDuration();
    Company getCompany();
    String getTitle();
    void setId(int position);
    void setTitle(String title);
    void setDescription(String description);
}
