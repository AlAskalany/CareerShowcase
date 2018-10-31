package com.alaskalany.careershowcase.model;

public interface Contact
        extends Model {

    int getContactId();

    void setContactId(int contactId);

    String getContactContent();

    void setContactContent(String contactContent);

    String getContactDetails();

    void setContactDetails(String contactDetails);
}
