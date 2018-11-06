package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.WorkEntity;

import java.util.List;

public class WorkRepository {

    private final DataRepository dataRepository;

    public MediatorLiveData<List<WorkEntity>> observableWorks;

    public WorkRepository(DataRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public void insertAll(List<WorkEntity> workEntities) {

    }

    public LiveData<WorkEntity> load(int workId) {

        return dataRepository.getDatabase()
                .workDao()
                .load(workId);
    }

    public WorkEntity loadSync(int workId) {

        return dataRepository.getDatabase()
                .workDao()
                .loadSync(workId);
    }

    public LiveData<List<WorkEntity>> loadAll() {

        return dataRepository.getDatabase()
                .workDao()
                .loadAll();
    }

    public MediatorLiveData<List<WorkEntity>> getWorks() {

        return observableWorks;
    }
}
