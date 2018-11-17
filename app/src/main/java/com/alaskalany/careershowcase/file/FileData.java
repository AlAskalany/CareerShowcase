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

package com.alaskalany.careershowcase.file;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.alaskalany.careershowcase.entity.ContactEntity;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;

import java.util.List;

public class FileData {
    
    private static final FileData INSTANCE = new FileData();
    
    private static final MediatorLiveData<List<EducationEntity>> educationLiveData = new MediatorLiveData<>();
    
    private static final MediatorLiveData<List<SkillEntity>> skillsLiveData = new MediatorLiveData<>();
    
    private static final MediatorLiveData<List<WorkEntity>> workLiveData = new MediatorLiveData<>();
    
    private static MutableLiveData<List<ContactEntity>> contactsLiveData = new MediatorLiveData<>();
    
    private FileData() {
    
    }
    
    @Contract(pure = true)
    public static FileData getInstance() {
        
        return INSTANCE;
    }
    
    public static LiveData<List<EducationEntity>> getEducationLiveData(Application application) {
        
        if (educationLiveData.getValue() == null) {
            loadEducation(application);
        }
        return educationLiveData;
    }
    
    private static void loadEducation(@NonNull Application application) {
        
        Gson gson = new Gson();
        DataJson dataJson =
                gson.fromJson(JsonFileReader.loadJSONFromAsset(application.getApplicationContext()), DataJson.class);
        educationLiveData.postValue(dataJson.education);
    }
    
    public static LiveData<List<SkillEntity>> getSkillsLiveData(Application application) {
        
        if (skillsLiveData.getValue() == null) {
            loadSkills(application);
        }
        return skillsLiveData;
    }
    
    private static void loadSkills(@NonNull Application application) {
        
        Gson gson = new Gson();
        DataJson dataJson =
                gson.fromJson(JsonFileReader.loadJSONFromAsset(application.getApplicationContext()), DataJson.class);
        skillsLiveData.postValue(dataJson.skills);
    }
    
    public static LiveData<List<WorkEntity>> getWorkLiveData(Application application) {
        
        if (workLiveData.getValue() == null) {
            loadWork(application);
        }
        return workLiveData;
    }
    
    private static void loadWork(@NonNull Application application) {
        
        Gson gson = new Gson();
        DataJson dataJson =
                gson.fromJson(JsonFileReader.loadJSONFromAsset(application.getApplicationContext()), DataJson.class);
        workLiveData.postValue(dataJson.work);
    }
    
    public static LiveData<List<ContactEntity>> getContactsLiveData(Application application) {
        
        if (contactsLiveData.getValue() == null) {
            loadContacts(application);
        }
        return contactsLiveData;
    }
    
    private static void loadContacts(@NonNull Application application) {
        
        Gson gson = new Gson();
        DataJson dataJson =
                gson.fromJson(JsonFileReader.loadJSONFromAsset(application.getApplicationContext()), DataJson.class);
        contactsLiveData.postValue(dataJson.contacts);
    }
}
