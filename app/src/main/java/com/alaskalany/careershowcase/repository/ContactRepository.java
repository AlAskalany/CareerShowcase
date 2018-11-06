package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.ContactEntity;

import java.util.List;

public class ContactRepository {

    private final DataRepository dataRepository;

    private MediatorLiveData<List<ContactEntity>> observableContacts;

    public ContactRepository(DataRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public MediatorLiveData<List<ContactEntity>> getObservableContacts() {

        return observableContacts;
    }

    public void setObservableContacts(MediatorLiveData<List<ContactEntity>> observableContacts) {

        this.observableContacts = observableContacts;
    }

    public void insertAll(List<ContactEntity> contactEntities) {

    }

    public LiveData<ContactEntity> load(int contactId) {

        return dataRepository.getDatabase()
                .contactDao()
                .load(contactId);
    }

    public ContactEntity loadSync(int contactId) {

        return dataRepository.getDatabase()
                .contactDao()
                .loadSync(contactId);
    }

    public LiveData<List<ContactEntity>> loadAll() {

        return dataRepository.getDatabase()
                .contactDao()
                .loadAll();
    }

    public MediatorLiveData<List<ContactEntity>> getContacts() {

        return observableContacts;
    }
}
