package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.DataRepository;
import com.alaskalany.careershowcase.database.entity.SkillEntity;

import java.util.List;

public class SkillRepository {

    private final DataRepository mDataRepository;

    private MediatorLiveData<List<SkillEntity>> mObservableSkills;

    public SkillRepository(DataRepository pMDataRepository) {

        mDataRepository = pMDataRepository;
    }

    public MediatorLiveData<List<SkillEntity>> getObservableSkills() {

        return mObservableSkills;
    }

    public void setObservableSkills(MediatorLiveData<List<SkillEntity>> pObservableSkills) {

        mObservableSkills = pObservableSkills;
    }

    public void insertAll(List<SkillEntity> skillEntities) {

    }

    public LiveData<SkillEntity> load(int skillId) {

        return mDataRepository.getDatabase()
                              .skillDao()
                              .load(skillId);
    }

    public SkillEntity loadSync(int skillId) {

        return mDataRepository.getDatabase()
                              .skillDao()
                              .loadSync(skillId);
    }

    public LiveData<List<SkillEntity>> loadAll() {

        return mDataRepository.getDatabase()
                              .skillDao()
                              .loadAll();
    }

    public MediatorLiveData<List<SkillEntity>> getSkills() {

        return mObservableSkills;
    }
}
