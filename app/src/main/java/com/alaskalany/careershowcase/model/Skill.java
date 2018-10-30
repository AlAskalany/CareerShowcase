package com.alaskalany.careershowcase.model;

import androidx.annotation.NonNull;

/**
 *
 */
public interface Skill
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
    String getDescription();
    /**
     * @param description
     */
    void setDescription(String description);
    /**
     * @return
     */
    @NonNull
    @Override
    String toString();
}
