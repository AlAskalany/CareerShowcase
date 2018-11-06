package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.EducationEntity;

import java.util.List;

public class EducationRepository {

    private final DataRepository dataRepository;

    private MediatorLiveData<List<EducationEntity>> observableEducations;

    public EducationRepository(DataRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public MediatorLiveData<List<EducationEntity>> getObservableEducations() {

        return observableEducations;
    }

    public void setObservableEducations(MediatorLiveData<List<EducationEntity>> observableEducations) {

        this.observableEducations = observableEducations;
    }

    public void insertAll(List<EducationEntity> educationEntities) {

    }

    public LiveData<EducationEntity> load(int educationId) {

        return dataRepository.getDatabase()
                .educationDao()
                .load(educationId);
    }

    public EducationEntity loadSync(int educationId) {

        return dataRepository.getDatabase()
                .educationDao()
                .loadSync(educationId);
    }

    public LiveData<List<EducationEntity>> loadAll() {

        return dataRepository.getDatabase()
                .educationDao()
                .loadAll();
    }

    public MediatorLiveData<List<EducationEntity>> getEducations() {

        return observableEducations;
    }
}
