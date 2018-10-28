package com.alaskalany.careershowcase.data.dummy;

import androidx.annotation.NonNull;

/**
 * A dummy item representing a piece of content.
 */
public class DummyItem {

    @SuppressWarnings("WeakerAccess")
    public final String id;
    @SuppressWarnings("WeakerAccess")
    public final String content;
    @SuppressWarnings("WeakerAccess")
    public final String details;

    @SuppressWarnings("WeakerAccess")
    public DummyItem(String id, String content, String details) {

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
