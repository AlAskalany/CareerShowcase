package com.alaskalany.careershowcase.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Contact;

/**
 * A contact item representing a piece of description.
 */
@Entity(tableName = "contacts_table")
public class ContactEntity
        implements Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    private int id;

    @ColumnInfo(name = "contact_title")
    private String title;

    @ColumnInfo(name = "contact_description")
    private String description;

    @ColumnInfo(name = "contact_logo_url")
    private String logoUrl;

    public ContactEntity() {

    }

    @Ignore
    @SuppressWarnings("WeakerAccess")
    public ContactEntity(int id, String title, String description) {

        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getId() {

        return id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    @Override
    public String getTitle() {

        return title;
    }

    @Override
    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public String getDescription() {

        return description;
    }

    @Override
    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String getLogoUrl() {

        return logoUrl;
    }

    @Override
    public void setLogoUrl(String logoUrl) {

        this.logoUrl = logoUrl;
    }
}
