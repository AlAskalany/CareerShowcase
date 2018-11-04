package com.alaskalany.careershowcase.file;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.google.gson.Gson;
import org.jetbrains.annotations.Contract;

import java.util.List;

public class FileData {

    private static final FileData ourInstance = new FileData();

    private static final MediatorLiveData<List<EducationEntity>> educationLiveData = new MediatorLiveData<>();

    private static final MediatorLiveData<List<SkillEntity>> skillsLiveData = new MediatorLiveData<>();

    private static final MediatorLiveData<List<WorkEntity>> workLiveData = new MediatorLiveData<>();

    private FileData() {

    }

    @Contract(pure = true)
    public static FileData getInstance() {

        return ourInstance;
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
}
