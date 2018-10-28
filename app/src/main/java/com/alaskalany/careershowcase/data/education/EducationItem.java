package com.alaskalany.careershowcase.data.education;

import androidx.annotation.NonNull;

/**
 * A education item representing a piece of content.
 */
public class EducationItem {

    @SuppressWarnings("WeakerAccess")
    public final String id;
    @SuppressWarnings("WeakerAccess")
    public final String content;
    @SuppressWarnings("WeakerAccess")
    public final String details;

    @SuppressWarnings("WeakerAccess")
    public EducationItem(String id, String content, String details) {

        this.id = id;
        this.content = content;
        this.details = details;
    }

    @NonNull
    @Override
    public String toString() {

        return content;
    }
}
