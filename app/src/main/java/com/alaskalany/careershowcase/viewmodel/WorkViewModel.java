package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.alaskalany.careershowcase.repository.DataRepository;

public class WorkViewModel
        extends AndroidViewModel {

    private final LiveData<WorkEntity> observableWork;

    private final int workId;

    public ObservableField<WorkEntity> work = new ObservableField<>();

    public WorkViewModel(@NonNull Application application, DataRepository dataRepository, final int workId) {

        super(application);
        this.workId = workId;
        observableWork = dataRepository.workRepository.load(workId);
    }

    public LiveData<WorkEntity> getObservableWork() {

        return observableWork;
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
        private final Application application;

        private final int workId;

        private final DataRepository repository;

        public Factory(@NonNull Application application, int workId) {

            this.application = application;
            this.workId = workId;
            repository = ((CareerShowcaseApp) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new WorkViewModel(application, repository, workId);
        }
    }
}
