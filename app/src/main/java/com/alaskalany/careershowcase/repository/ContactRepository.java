package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.ContactEntity;

import java.util.List;

public class ContactRepository {

    private final DataRepository mDataRepository;

    private MediatorLiveData<List<ContactEntity>> mObservableContacts;

    public ContactRepository(DataRepository pMDataRepository) {

        mDataRepository = pMDataRepository;
    }

    public MediatorLiveData<List<ContactEntity>> getObservableContacts() {

        return mObservableContacts;
    }

    public void setObservableContacts(MediatorLiveData<List<ContactEntity>> pObservableContacts) {

        mObservableContacts = pObservableContacts;
    }

    public void insertAll(List<ContactEntity> contactEntities) {

    }

    public LiveData<ContactEntity> load(int contactId) {

        return mDataRepository.getDatabase()
                              .contactDao()
                              .load(contactId);
    }

    public ContactEntity loadSync(int contactId) {

        return mDataRepository.getDatabase()
                              .contactDao()
                              .loadSync(contactId);
    }

    public LiveData<List<ContactEntity>> loadAll() {

        return mDataRepository.getDatabase()
                              .contactDao()
                              .loadAll();
    }

    public MediatorLiveData<List<ContactEntity>> getContacts() {

        return mObservableContacts;
    }
}
