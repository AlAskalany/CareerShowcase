package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.DataRepository;
import com.alaskalany.careershowcase.database.entity.WorkEntity;

public class WorkViewModel
        extends AndroidViewModel {

    private final LiveData<WorkEntity> mObservableWork;

    private final int mWorkId;

    public ObservableField<WorkEntity> work = new ObservableField<>();

    public WorkViewModel(@NonNull Application application, DataRepository dataRepository, final int workId) {

        super(application);
        mWorkId = workId;
        mObservableWork = dataRepository.load(workId);
    }

    public LiveData<WorkEntity> getObservableWork() {

        return mObservableWork;
    }

    public void setWork(WorkEntity product) {

        this.work.set(product);
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

        private final int mWorkId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int workId) {

            mApplication = application;
            mWorkId = workId;
            mRepository = ((CareerShowcaseApp) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new WorkViewModel(mApplication, mRepository, mWorkId);
        }
    }
}
