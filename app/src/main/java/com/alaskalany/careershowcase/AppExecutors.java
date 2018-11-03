package com.alaskalany.careershowcase;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    /**
     *
     */
    private final Executor mDiskIO;

    /**
     *
     */
    private final Executor mNetworkIO;

    /**
     *
     */
    private final Executor mMainThread;

    /**
     *
     */
    public AppExecutors() {

        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new MainThreadExecutor());
    }

    /**
     * @param diskIO
     * @param networkIO
     * @param mainThread
     */
    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {

        this.mDiskIO = diskIO;
        this.mNetworkIO = networkIO;
        this.mMainThread = mainThread;
    }

    /**
     * @return
     */
    public Executor diskIO() {

        return mDiskIO;
    }

    /**
     * @return
     */
    public Executor networkIO() {

        return mNetworkIO;
    }

    /**
     * @return
     */
    public Executor mainThread() {

        return mMainThread;
    }

    /**
     *
     */
    private static class MainThreadExecutor
            implements Executor {

        /**
         *
         */
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {

            mainThreadHandler.post(command);
        }
    }
}
