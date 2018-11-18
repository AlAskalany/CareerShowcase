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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.alaskalany.careershowcase.entity.ContactEntity;

import java.util.List;

public class ContactRepository {
    
    private final DataRepository dataRepository;
    
    private MediatorLiveData<List<ContactEntity>> observableContacts;
    
    public ContactRepository(DataRepository dataRepository) {
        
        this.dataRepository = dataRepository;
    }
    
    public MediatorLiveData<List<ContactEntity>> getObservableContacts() {
        
        return observableContacts;
    }
    
    public void setObservableContacts(MediatorLiveData<List<ContactEntity>> observableContacts) {
        
        this.observableContacts = observableContacts;
    }
    
    public void insertAll(List<ContactEntity> contactEntities) {
    
    }
    
    public LiveData<ContactEntity> load(int contactId) {
        
        return dataRepository.getDatabase().contactDao().load(contactId);
    }
    
    public ContactEntity loadSync(int contactId) {
        
        return dataRepository.getDatabase().contactDao().loadSync(contactId);
    }
    
    public LiveData<List<ContactEntity>> loadAll() {
        
        return dataRepository.getDatabase().contactDao().loadAll();
    }
    
    public MediatorLiveData<List<ContactEntity>> getContacts() {
        
        return observableContacts;
    }
}
