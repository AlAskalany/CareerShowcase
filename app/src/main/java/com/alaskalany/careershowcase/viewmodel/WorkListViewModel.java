package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.alaskalany.careershowcase.file.FileData;
import com.alaskalany.careershowcase.repository.DataRepository;

import java.util.List;

public class WorkListViewModel
        extends AndroidViewModel {

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<WorkEntity>> observableProducts;

    public WorkListViewModel(Application application) {

        super(application);
        observableProducts = new MediatorLiveData<>();
        // set by default null, until we get data from the database.
        observableProducts.setValue(null);
        //LiveData<List<WorkEntity>> works = ((CareerShowcaseApp) application).getRepository().workRepository.getWorks();
        LiveData<List<WorkEntity>> listLiveData = FileData.getWorkLiveData(application);
        // observe the changes of the products from the database and forward them
        observableProducts.addSource(listLiveData, observableProducts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<WorkEntity>> getWorks() {

        return observableProducts;
    }

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
