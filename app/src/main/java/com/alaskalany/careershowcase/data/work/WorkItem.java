package com.alaskalany.careershowcase.data.work;

import androidx.annotation.NonNull;

/**
 * A work item representing a piece of content.
 */
public class WorkItem {

    @SuppressWarnings("WeakerAccess")
    public final String id;
    @SuppressWarnings("WeakerAccess")
    public final String content;
    @SuppressWarnings("WeakerAccess")
    public final String details;

    @SuppressWarnings("WeakerAccess")
    public WorkItem(String id, String content, String details) {

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
