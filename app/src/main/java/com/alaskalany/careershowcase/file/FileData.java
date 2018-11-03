package com.alaskalany.careershowcase.file;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class FileData {

    private static final FileData ourInstance = new FileData();

    public static FileData getInstance() {

        return ourInstance;
    }

    private FileData() {

    }

    public String loadJSONFromAsset(Context context) {

        InputStream is = context.getResources()
                                 .openRawResource(R.raw.data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return writer.toString();
    }

    public List<WorkEntity> getWork(Context context) {

        Gson gson = new Gson();
        DataJson dataJson = gson.fromJson(loadJSONFromAsset(context), DataJson.class);
        return dataJson.work;
    }

    public List<EducationEntity> getEducation(FragmentActivity activity) {

        Gson gson = new Gson();
        DataJson dataJson = gson.fromJson(loadJSONFromAsset(activity), DataJson.class);
        return dataJson.education;
    }

    public List<SkillEntity> getSkills(FragmentActivity activity) {

        Gson gson = new Gson();
        DataJson dataJson = gson.fromJson(loadJSONFromAsset(activity), DataJson.class);
        return dataJson.skills;
    }
}
