package com.alaskalany.careershowcase;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * App {@link Executor}s
 */
public class AppExecutors {

    /**
     * Disk IO {@link Executor}
     */
    private final Executor diskIoExecutor;

    /**
     * Network IO {@link Executor}
     */
    private final Executor networkIoExecutor;

    /**
     * Main thread {@link Executor}
     */
    private final Executor mainThreadExecutor;

    /**
     * App {@link Executor}s
     */
    public AppExecutors() {

        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new MainThreadExecutor());
    }

    /**
     * @param diskIO     Disk IO {@link Executor}
     * @param networkIO  Network IO {@link Executor}
     * @param mainThread Main thread {@link Executor}
     */
    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {

        this.diskIoExecutor = diskIO;
        this.networkIoExecutor = networkIO;
        this.mainThreadExecutor = mainThread;
    }

    /**
     * @return DisK IO {@link Executor}
     */
    public Executor diskIO() {

        return diskIoExecutor;
    }

    /**
     * @return Network IO {@link Executor}
     */
    public Executor networkIO() {

        return networkIoExecutor;
    }

    /**
     * @return Main thread {@link Executor}
     */
    public Executor mainThread() {

        return mainThreadExecutor;
    }

    /**
     * Main thread {@link Executor}
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
