/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase;

import android.app.Application;
import androidx.room.RoomDatabase;
import com.alaskalany.careershowcase.database.AppDatabase;
import com.alaskalany.careershowcase.repository.DataRepository;

import java.util.concurrent.Executor;

/**
 * App class extending {@link Application}
 */
public class CareerShowcaseApp
        extends Application {

    /**
     * App executors; Disk IO {@link Executor},Network {@link Executor},and Main thread {@link Executor}.
     */
    private AppExecutors appExecutors;

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * <p>Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.</p>
     * <p>If you override this method, be sure to call {@code super.onCreate()}.</p>
     * <p class="note">Be aware that direct boot may also affect callback order on
     * Android {@link android.os.Build.VERSION_CODES#N} and later devices.
     * Until the user unlocks the device, only direct boot aware components are
     * allowed to run. You should consider that all direct boot unaware
     * components, including such {@link android.content.ContentProvider}, are
     * disabled until user unlock happens, especially when component callback
     * order matters.</p>
     */
    @Override
    public void onCreate() {

        super.onCreate();
        appExecutors = new AppExecutors();
    }

    /**
     * Gets {@link DataRepository}
     *
     * @return Data repository
     */
    public DataRepository getRepository() {

        return DataRepository.Companion.getInstance(getDatabase());
    }

    /**
     * @return Application's {@link RoomDatabase}
     */
    public AppDatabase getDatabase() {

        return AppDatabase.Companion.getInstance(this, appExecutors);
    }
}
