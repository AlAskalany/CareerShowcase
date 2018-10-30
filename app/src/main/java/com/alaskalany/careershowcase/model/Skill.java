package com.alaskalany.careershowcase.model;

import androidx.annotation.NonNull;

public interface Skill
        extends Model {

    int getId();
    void setId(int id);
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);
    @NonNull
    @Override
    String toString();
}
