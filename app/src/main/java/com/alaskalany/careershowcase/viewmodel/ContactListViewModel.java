package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.database.entity.ContactEntity;

import java.util.List;

public class ContactListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<ContactEntity>> mObservableContacts;

    public ContactListViewModel(Application application) {

        super(application);

        mObservableContacts = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableContacts.setValue(null);
        LiveData<List<ContactEntity>> contacts =
                ((CareerShowcaseApp) application).getRepository().mContactRepository.getContacts();

        // observe the changes of the products from the database and forward them
        mObservableContacts.addSource(contacts, mObservableContacts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<ContactEntity>> getContacts() {

        return mObservableContacts;
    }
}
