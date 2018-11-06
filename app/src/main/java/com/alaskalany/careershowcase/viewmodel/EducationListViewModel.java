package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.file.FileData;

import java.util.List;

public class EducationListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<EducationEntity>> observableEducations;

    public EducationListViewModel(Application application) {

        super(application);
        observableEducations = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        observableEducations.setValue(null);
        // LiveData<List<EducationEntity>> educations = ((CareerShowcaseApp) application).getRepository().educationRepository.getEducations();
        LiveData<List<EducationEntity>> listLiveData = FileData.getEducationLiveData(application);
        // observe the changes of the products from the database and forward them
        observableEducations.addSource(listLiveData, observableEducations::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<EducationEntity>> getEducations() {

        return observableEducations;
    }
}
