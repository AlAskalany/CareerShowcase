package com.alaskalany.careershowcase.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alaskalany.careershowcase.database.entity.WorkEntity;
import com.alaskalany.careershowcase.model.Work;

public class WorkViewModel
        extends AndroidViewModel {

    private MutableLiveData<Work> work;

    public WorkViewModel(@NonNull Application application) {

        super(application);
    }

    public LiveData<Work> getWork() {

        if (work == null) {
            work = new MutableLiveData<>();
            loadWork();
        }
        return work;
    }

    private void loadWork() {

        WorkEntity value = new WorkEntity();
        value.setTitle("My title");
        value.setDescription("My Description");
        work.setValue(value);
    }
}
