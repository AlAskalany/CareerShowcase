package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

import java.util.List;

public class WorkListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<WorkEntity>> mObservableProducts;

    public WorkListViewModel(Application application) {

        super(application);

        mObservableProducts = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableProducts.setValue(null);

        LiveData<List<WorkEntity>> works = ((CareerShowcaseApp) application).getRepository().getWorks();

        // observe the changes of the products from the database and forward them
        mObservableProducts.addSource(works, mObservableProducts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<WorkEntity>> getWorks() {

        return mObservableProducts;
    }
}
