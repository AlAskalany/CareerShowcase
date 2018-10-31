package com.alaskalany.careershowcase.database.entity;

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
    private int contactId;

    private String contactContent;

    private String contactDetails;

    public ContactEntity() {

    }

    @Ignore
    @SuppressWarnings("WeakerAccess")
    public ContactEntity(int contactId, String contactContent, String contactDetails) {

        this.contactId = contactId;
        this.contactContent = contactContent;
        this.contactDetails = contactDetails;
    }

    @Override
    public int getContactId() {

        return contactId;
    }

    @Override
    public void setContactId(int contactId) {

        this.contactId = contactId;
    }

    @Override
    public String getContactContent() {

        return contactContent;
    }

    @Override
    public void setContactContent(String contactContent) {

        this.contactContent = contactContent;
    }

    @Override
    public String getContactDetails() {

        return contactDetails;
    }

    @Override
    public void setContactDetails(String contactDetails) {

        this.contactDetails = contactDetails;
    }
}
