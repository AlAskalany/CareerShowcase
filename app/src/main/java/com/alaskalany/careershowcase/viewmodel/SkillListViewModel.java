package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.file.FileData;

import java.util.List;

public class SkillListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<SkillEntity>> mObservableSkills;

    public SkillListViewModel(Application application) {

        super(application);
        mObservableSkills = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        mObservableSkills.setValue(null);
        //LiveData<List<SkillEntity>> skills = ((CareerShowcaseApp) application).getRepository().mSkillRepository.getSkills();
        LiveData<List<SkillEntity>> listLiveData = FileData.getSkillsLiveData(application);
        // observe the changes of the products from the database and forward them
        mObservableSkills.addSource(listLiveData, mObservableSkills::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<SkillEntity>> getSkills() {

        return mObservableSkills;
    }
}
