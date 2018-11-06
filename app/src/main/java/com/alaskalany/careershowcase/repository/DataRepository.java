package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.database.AppDatabase;

public class DataRepository {

    private static DataRepository INSTANCE;
    public final ContactRepository contactRepository = new ContactRepository(this);
    public final WorkRepository workRepository = new WorkRepository(this);
    public final SkillRepository skillRepository = new SkillRepository(this);
    public final EducationRepository educationRepository = new EducationRepository(this);
    private final AppDatabase appDatabase;

    private DataRepository(final AppDatabase database) {

        appDatabase = database;
        workRepository.observableWorks = new MediatorLiveData<>();
        workRepository.observableWorks.addSource(workRepository.loadAll(), workEntities -> {
            if (isDatabaseCreated() != null) {
                workRepository.observableWorks.postValue(workEntities);
            }
        });
        educationRepository.setObservableEducations(new MediatorLiveData<>());
        educationRepository.getObservableEducations()
                .addSource(educationRepository.loadAll(), educationEntities -> {
                    if (isDatabaseCreated() != null) {
                        educationRepository.getObservableEducations()
                                .postValue(educationEntities);
                    }
                });
        skillRepository.setObservableSkills(new MediatorLiveData<>());
        skillRepository.getObservableSkills()
                .addSource(skillRepository.loadAll(), skillEntities -> {
                    if (isDatabaseCreated() != null) {
                        skillRepository.getObservableSkills()
                                .postValue(skillEntities);
                    }
                });
        contactRepository.setObservableContacts(new MediatorLiveData<>());
        contactRepository.getObservableContacts()
                .addSource(contactRepository.loadAll(), contactEntities -> {
                    if (isDatabaseCreated() != null) {
                        contactRepository.getObservableContacts()
                                .postValue(contactEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {

        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(database);
                }
            }
        }
        return INSTANCE;
    }

    private Boolean isDatabaseCreated() {

        return appDatabase.getDatabaseCreated()
                .getValue();
    }

    public AppDatabase getDatabase() {

        return appDatabase;
    }
}
