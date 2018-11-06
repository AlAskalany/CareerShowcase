package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.repository.DataRepository;

public class EducationViewModel
        extends AndroidViewModel {

    private final LiveData<EducationEntity> observableEducation;

    private final int educationId;

    public ObservableField<EducationEntity> education = new ObservableField<EducationEntity>();

    public EducationViewModel(@NonNull Application application, DataRepository dataRepository, final int educationId) {

        super(application);
        this.educationId = educationId;
        observableEducation = dataRepository.educationRepository.load(educationId);
    }

    public LiveData<EducationEntity> getObservableEducation() {

        return observableEducation;
    }

    public void setEducation(EducationEntity education) {

        this.education.set(education);
    }

    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */
    public static class Factory
            extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mEducationId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int educationId) {

            mApplication = application;
            mEducationId = educationId;
            mRepository = ((CareerShowcaseApp) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new EducationViewModel(mApplication, mRepository, mEducationId);
        }
    }
}
