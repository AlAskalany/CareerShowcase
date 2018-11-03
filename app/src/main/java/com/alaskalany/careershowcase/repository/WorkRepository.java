package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.WorkEntity;

import java.util.List;

public class WorkRepository {

    private final DataRepository mDataRepository;

    public MediatorLiveData<List<WorkEntity>> mObservableWorks;

    public WorkRepository(DataRepository pMDataRepository) {

        mDataRepository = pMDataRepository;
    }

    public void insertAll(List<WorkEntity> workEntities) {

    }

    public LiveData<WorkEntity> load(int workId) {

        return mDataRepository.getDatabase()
                              .workDao()
                              .load(workId);
    }

    public WorkEntity loadSync(int workId) {

        return mDataRepository.getDatabase()
                              .workDao()
                              .loadSync(workId);
    }

    public LiveData<List<WorkEntity>> loadAll() {

        return mDataRepository.getDatabase()
                              .workDao()
                              .loadAll();
    }

    public MediatorLiveData<List<WorkEntity>> getWorks() {

        return mObservableWorks;
    }
}
