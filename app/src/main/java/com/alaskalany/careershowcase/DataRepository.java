package com.alaskalany.careershowcase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.database.AppDatabase;
import com.alaskalany.careershowcase.database.dao.ContactDao;
import com.alaskalany.careershowcase.database.dao.EducationDao;
import com.alaskalany.careershowcase.database.dao.SkillDao;
import com.alaskalany.careershowcase.database.dao.WorkDao;
import com.alaskalany.careershowcase.database.entity.ContactEntity;
import com.alaskalany.careershowcase.database.entity.EducationEntity;
import com.alaskalany.careershowcase.database.entity.SkillEntity;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

import java.util.List;

public class DataRepository
        implements WorkDao, EducationDao, SkillDao, ContactDao {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;

    private MediatorLiveData<List<WorkEntity>> mObservableWorks;

    private MediatorLiveData<List<EducationEntity>> mObservableEducations;

    private MediatorLiveData<List<SkillEntity>> mObservableSkills;

    private MediatorLiveData<List<ContactEntity>> mObservableContacts;

    private DataRepository(final AppDatabase database) {

        mDatabase = database;
        mObservableWorks = new MediatorLiveData<>();
        mObservableWorks.addSource(loadAllWorks(), workEntities -> {
            if (isDatabaseCreated() != null) {
                mObservableWorks.postValue(workEntities);
            }
        });
        mObservableEducations = new MediatorLiveData<>();
        mObservableEducations.addSource(loadAllEducation(), educationEntities -> {
            if (isDatabaseCreated() != null) {
                mObservableEducations.postValue(educationEntities);
            }
        });
        mObservableSkills = new MediatorLiveData<>();
        mObservableSkills.addSource(loadAllSkills(), skillEntities -> {
            if (isDatabaseCreated() != null) {
                mObservableSkills.postValue(skillEntities);
            }
        });
        mObservableContacts = new MediatorLiveData<>();
        mObservableContacts.addSource(loadAllContacts(), contactEntities -> {
            if (isDatabaseCreated() != null) {
                mObservableContacts.postValue(contactEntities);
            }
        });
    }

    private Boolean isDatabaseCreated() {

        return mDatabase.getDatabaseCreated().getValue();
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

    @Override
    public void insertAllContacts(List<ContactEntity> contactEntities) {

    }

    @Override
    public LiveData<ContactEntity> loadContact(int contactId) {

        return mDatabase.contactDao().loadContact(contactId);
    }

    @Override
    public ContactEntity loadContactSync(int contactId) {

        return mDatabase.contactDao().loadContactSync(contactId);
    }

    @Override
    public LiveData<List<ContactEntity>> loadAllContacts() {

        return mDatabase.contactDao().loadAllContacts();
    }

    @Override
    public void insertAllEducation(List<EducationEntity> educationEntities) {

    }

    @Override
    public LiveData<EducationEntity> loadEducation(int educationId) {

        return mDatabase.educationDao().loadEducation(educationId);
    }

    @Override
    public EducationEntity loadEducationSync(int educationId) {

        return mDatabase.educationDao().loadEducationSync(educationId);
    }

    @Override
    public LiveData<List<EducationEntity>> loadAllEducation() {

        return mDatabase.educationDao().loadAllEducation();
    }

    @Override
    public void insertAllSkills(List<SkillEntity> skillEntities) {

    }

    @Override
    public LiveData<SkillEntity> loadSkill(int skillId) {

        return mDatabase.skillDao().loadSkill(skillId);
    }

    @Override
    public SkillEntity loadSkillSync(int skillId) {

        return mDatabase.skillDao().loadSkillSync(skillId);
    }

    @Override
    public LiveData<List<SkillEntity>> loadAllSkills() {

        return mDatabase.skillDao().loadAllSkills();
    }

    @Override
    public void insertAllWork(List<WorkEntity> workEntities) {

    }

    @Override
    public LiveData<WorkEntity> loadWork(int workId) {

        return mDatabase.workDao().loadWork(workId);
    }

    @Override
    public WorkEntity loadWorkSync(int workId) {

        return mDatabase.workDao().loadWorkSync(workId);
    }

    @Override
    public LiveData<List<WorkEntity>> loadAllWorks() {

        return mDatabase.workDao().loadAllWorks();
    }

    public MediatorLiveData<List<WorkEntity>> getWorks() {

        return mObservableWorks;
    }

    public MediatorLiveData<List<EducationEntity>> getEducations() {

        return mObservableEducations;
    }

    public MediatorLiveData<List<SkillEntity>> getSkills() {

        return mObservableSkills;
    }

    public MediatorLiveData<List<ContactEntity>> getContacts() {

        return mObservableContacts;
    }
}
