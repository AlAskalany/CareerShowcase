package com.alaskalany.careershowcase;

import android.app.Application;
import com.alaskalany.careershowcase.database.AppDatabase;
import com.alaskalany.careershowcase.repository.DataRepository;

public class CareerShowcaseApp
        extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {

        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public DataRepository getRepository() {

        return DataRepository.getInstance(getDatabase());
    }

    public AppDatabase getDatabase() {

        return AppDatabase.getInstance(this, mAppExecutors);
    }
}
