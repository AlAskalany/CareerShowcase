package com.alaskalany.careershowcase.data.skills;

import androidx.annotation.NonNull;

/**
 * A skill item representing a piece of content.
 */
public class SkillItem {

    @SuppressWarnings("WeakerAccess")
    public final String id;
    @SuppressWarnings("WeakerAccess")
    public final String content;
    @SuppressWarnings("WeakerAccess")
    public final String details;

    @SuppressWarnings("WeakerAccess")
    public SkillItem(String id, String content, String details) {

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
