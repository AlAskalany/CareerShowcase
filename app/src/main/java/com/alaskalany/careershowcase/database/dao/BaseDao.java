package com.alaskalany.careershowcase.database.dao;

import androidx.lifecycle.LiveData;
import com.alaskalany.careershowcase.model.Model;

import java.util.List;

public interface BaseDao<T extends Model> {

    void insertAll(List<T> contactEntities);

    LiveData<T> load(int contactId);

    T loadSync(int contactId);

    LiveData<List<T>> loadAll();
}
