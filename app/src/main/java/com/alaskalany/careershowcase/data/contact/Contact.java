package com.alaskalany.careershowcase.data.contact;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A contact item representing a piece of description.
 */
@Entity
public class Contact {

    @PrimaryKey
    @SuppressWarnings("WeakerAccess")
    public String id;
    @SuppressWarnings("WeakerAccess")
    public String content;
    @SuppressWarnings("WeakerAccess")
    public String details;

    @SuppressWarnings("WeakerAccess")
    public Contact(String id, String content, String details) {

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
