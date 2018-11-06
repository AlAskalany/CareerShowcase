package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.ContactEntity;
import com.alaskalany.careershowcase.file.FileData;

import java.util.List;

public class ContactListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<ContactEntity>> observableContacts;

    public ContactListViewModel(Application application) {

        super(application);

        observableContacts = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        observableContacts.setValue(null);
        // LiveData<List<ContactEntity>> contacts = ((CareerShowcaseApp) application).getRepository().contactRepository.getContacts();
        LiveData<List<ContactEntity>> listLiveData = FileData.getContactsLiveData(application);
        // observe the changes of the products from the database and forward them
        observableContacts.addSource(listLiveData, observableContacts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<ContactEntity>> getContacts() {

        return observableContacts;
    }
}
