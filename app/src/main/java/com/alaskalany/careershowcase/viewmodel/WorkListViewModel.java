package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

import java.util.List;

/**
 *
 */
public class WorkListViewModel
        extends AndroidViewModel {

    /**
     *
     */
    private MediatorLiveData<List<WorkEntity>> observableWorks;

    /**
     * @param application
     */
    public WorkListViewModel(@NonNull Application application) {

        super(application);
        observableWorks = new MediatorLiveData<>();
        observableWorks.setValue(null);
        LiveData<List<WorkEntity>> works = null;
        observableWorks.addSource(works, observableWorks::setValue);
    }

    /**
     * @return
     */
    public LiveData<List<WorkEntity>> getWorks() {

        return observableWorks;
    }
}
