package com.alaskalany.careershowcase.data.contact;

import androidx.annotation.NonNull;

/**
 * A contact item representing a piece of content.
 */
public class ContactItem {

    @SuppressWarnings("WeakerAccess")
    public final String id;
    @SuppressWarnings("WeakerAccess")
    public final String content;
    @SuppressWarnings("WeakerAccess")
    public final String details;

    @SuppressWarnings("WeakerAccess")
    public ContactItem(String id, String content, String details) {

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
