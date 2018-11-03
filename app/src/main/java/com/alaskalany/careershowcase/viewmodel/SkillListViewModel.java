package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.entity.SkillEntity;

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
        LiveData<List<SkillEntity>> skills =
                ((CareerShowcaseApp) application).getRepository().mSkillRepository.getSkills();

        // observe the changes of the products from the database and forward them
        mObservableSkills.addSource(skills, mObservableSkills::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<SkillEntity>> getSkills() {

        return mObservableSkills;
    }
}
