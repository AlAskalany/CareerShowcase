package com.alaskalany.careershowcase;

import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.database.AppDatabase;
import com.alaskalany.careershowcase.repository.ContactRepository;
import com.alaskalany.careershowcase.repository.EducationRepository;
import com.alaskalany.careershowcase.repository.SkillRepository;
import com.alaskalany.careershowcase.repository.WorkRepository;

public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;

    public final ContactRepository mContactRepository = new ContactRepository(this);

    public final WorkRepository mWorkRepository = new WorkRepository(this);

    public final SkillRepository mSkillRepository = new SkillRepository(this);

    public final EducationRepository mEducationRepository = new EducationRepository(this);

    private DataRepository(final AppDatabase database) {

        mDatabase = database;
        mWorkRepository.mObservableWorks = new MediatorLiveData<>();
        mWorkRepository.mObservableWorks.addSource(mWorkRepository.loadAll(), workEntities -> {
            if (isDatabaseCreated() != null) {
                mWorkRepository.mObservableWorks.postValue(workEntities);
            }
        });
        mEducationRepository.setObservableEducations(new MediatorLiveData<>());
        mEducationRepository.getObservableEducations()
                            .addSource(mEducationRepository.loadAll(), educationEntities -> {
                                if (isDatabaseCreated() != null) {
                                    mEducationRepository.getObservableEducations()
                                                        .postValue(educationEntities);
                                }
                            });
        mSkillRepository.setObservableSkills(new MediatorLiveData<>());
        mSkillRepository.getObservableSkills()
                        .addSource(mSkillRepository.loadAll(), skillEntities -> {
                            if (isDatabaseCreated() != null) {
                                mSkillRepository.getObservableSkills()
                                                .postValue(skillEntities);
                            }
                        });
        mContactRepository.setObservableContacts(new MediatorLiveData<>());
        mContactRepository.getObservableContacts()
                          .addSource(mContactRepository.loadAll(), contactEntities -> {
                              if (isDatabaseCreated() != null) {
                                  mContactRepository.getObservableContacts()
                                                    .postValue(contactEntities);
                              }
                          });
    }

    private Boolean isDatabaseCreated() {

        return mDatabase.getDatabaseCreated()
                        .getValue();
    }

    public static DataRepository getInstance(final AppDatabase database) {

        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public AppDatabase getDatabase() {

        return mDatabase;
    }
}
