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

package com.alaskalany.careershowcase.repository;

import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.database.AppDatabase;

public class DataRepository {
    
    private static DataRepository INSTANCE;
    
    public final ContactRepository contactRepository = new ContactRepository(this);
    
    public final WorkRepository workRepository = new WorkRepository(this);
    
    public final SkillRepository skillRepository = new SkillRepository(this);
    
    public final EducationRepository educationRepository = new EducationRepository(this);
    
    private final AppDatabase appDatabase;
    
    private DataRepository(final AppDatabase database) {
        
        appDatabase = database;
        workRepository.observableWorks = new MediatorLiveData<>();
        workRepository.observableWorks.addSource(workRepository.loadAll(), workEntities -> {
            if (isDatabaseCreated() != null) {
                workRepository.observableWorks.postValue(workEntities);
            }
        });
        educationRepository.setObservableEducations(new MediatorLiveData<>());
        educationRepository.getObservableEducations().addSource(educationRepository.loadAll(), educationEntities -> {
            if (isDatabaseCreated() != null) {
                educationRepository.getObservableEducations().postValue(educationEntities);
            }
        });
        skillRepository.setObservableSkills(new MediatorLiveData<>());
        skillRepository.getObservableSkills().addSource(skillRepository.loadAll(), skillEntities -> {
            if (isDatabaseCreated() != null) {
                skillRepository.getObservableSkills().postValue(skillEntities);
            }
        });
        contactRepository.setObservableContacts(new MediatorLiveData<>());
        contactRepository.getObservableContacts().addSource(contactRepository.loadAll(), contactEntities -> {
            if (isDatabaseCreated() != null) {
                contactRepository.getObservableContacts().postValue(contactEntities);
            }
        });
    }
    
    private Boolean isDatabaseCreated() {
        
        return appDatabase.getDatabaseCreated().getValue();
    }
    
    public static DataRepository getInstance(final AppDatabase database) {
        
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(database);
                }
            }
        }
        return INSTANCE;
    }
    
    public AppDatabase getDatabase() {
        
        return appDatabase;
    }
}
