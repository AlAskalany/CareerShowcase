package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.EducationEntity;

import java.util.List;

public class EducationRepository {

    private final DataRepository mDataRepository;

    private MediatorLiveData<List<EducationEntity>> mObservableEducations;

    public EducationRepository(DataRepository pMDataRepository) {

        mDataRepository = pMDataRepository;
    }

    public MediatorLiveData<List<EducationEntity>> getObservableEducations() {

        return mObservableEducations;
    }

    public void setObservableEducations(MediatorLiveData<List<EducationEntity>> pObservableEducations) {

        mObservableEducations = pObservableEducations;
    }

    public void insertAll(List<EducationEntity> educationEntities) {

    }

    public LiveData<EducationEntity> load(int educationId) {

        return mDataRepository.getDatabase()
                              .educationDao()
                              .load(educationId);
    }

    public EducationEntity loadSync(int educationId) {

        return mDataRepository.getDatabase()
                              .educationDao()
                              .loadSync(educationId);
    }

    public LiveData<List<EducationEntity>> loadAll() {

        return mDataRepository.getDatabase()
                              .educationDao()
                              .loadAll();
    }

    public MediatorLiveData<List<EducationEntity>> getEducations() {

        return mObservableEducations;
    }
}
