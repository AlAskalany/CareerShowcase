package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import com.alaskalany.careershowcase.CareerShowcaseApp;
import com.alaskalany.careershowcase.file.FileData;
import com.alaskalany.careershowcase.repository.DataRepository;
import com.alaskalany.careershowcase.entity.WorkEntity;

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
        //LiveData<List<WorkEntity>> works = ((CareerShowcaseApp) application).getRepository().mWorkRepository.getWorks();
        LiveData<List<WorkEntity>> listLiveData = FileData.getWorkLiveData(application);
        // observe the changes of the products from the database and forward them
        mObservableProducts.addSource(listLiveData, mObservableProducts::setValue);
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<WorkEntity>> getWorks() {

        return mObservableProducts;
    }

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
