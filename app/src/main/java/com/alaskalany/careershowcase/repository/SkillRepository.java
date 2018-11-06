package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.SkillEntity;

import java.util.List;

public class SkillRepository {

    private final DataRepository dataRepository;

    private MediatorLiveData<List<SkillEntity>> observableSkills;

    public SkillRepository(DataRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public MediatorLiveData<List<SkillEntity>> getObservableSkills() {

        return observableSkills;
    }

    public void setObservableSkills(MediatorLiveData<List<SkillEntity>> observableSkills) {

        this.observableSkills = observableSkills;
    }

    public void insertAll(List<SkillEntity> skillEntities) {

    }

    public LiveData<SkillEntity> load(int skillId) {

        return dataRepository.getDatabase()
                .skillDao()
                .load(skillId);
    }

    public SkillEntity loadSync(int skillId) {

        return dataRepository.getDatabase()
                .skillDao()
                .loadSync(skillId);
    }

    public LiveData<List<SkillEntity>> loadAll() {

        return dataRepository.getDatabase()
                .skillDao()
                .loadAll();
    }

    public MediatorLiveData<List<SkillEntity>> getSkills() {

        return observableSkills;
    }
}
