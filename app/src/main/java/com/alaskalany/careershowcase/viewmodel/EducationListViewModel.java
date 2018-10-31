package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.database.entity.EducationEntity;

import java.util.List;

public class EducationListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<EducationEntity>> mObservableEducations;

    public EducationListViewModel(Application application) {

        super(application);

        mObservableEducations = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableEducations.setValue(null);

        LiveData<List<EducationEntity>> educations = ((CareerShowcaseApp) application).getRepository().getEducations();

        // observe the changes of the products from the database and forward them
        mObservableEducations.addSource(educations, mObservableEducations::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<EducationEntity>> getEducations() {

        return mObservableEducations;
    }
}
