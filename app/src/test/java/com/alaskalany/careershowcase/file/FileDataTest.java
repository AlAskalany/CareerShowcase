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

import androidx.lifecycle.LiveData;
import com.alaskalany.careershowcase.MainActivity;
import com.alaskalany.careershowcase.entity.ContactEntity;
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.entity.WorkEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class FileDataTest {
    
    private FileData fileData;
    
    @Before
    public void setUp() throws Exception {
        
        fileData = FileData.getInstance();
    }
    
    @After
    public void tearDown() throws Exception {
        
        fileData = null;
    }
    
    @Test
    public void getInstance() {
        
        assertNotNull(fileData);
    }
    
    @Test
    public void getEducationLiveData() {
        
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        LiveData<List<EducationEntity>> educationLiveData =
                FileData.INSTANCE.getEducationLiveData(mainActivity.getApplication());
        assertNotNull(educationLiveData);
    }
    
    @Test
    public void getSkillsLiveData() {
        
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        LiveData<List<SkillEntity>> skillsLiveData = FileData.INSTANCE.getSkillsLiveData(mainActivity.getApplication());
        assertNotNull(skillsLiveData);
    }
    
    @Test
    public void getWorkLiveData() {
        
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        LiveData<List<WorkEntity>> workLiveData = FileData.INSTANCE.getWorkLiveData(mainActivity.getApplication());
        assertNotNull(workLiveData);
    }
    
    @Test
    public void getContactsLiveData() {
        
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        LiveData<List<ContactEntity>> contactsLiveData = FileData.INSTANCE.getContactsLiveData(mainActivity.getApplication());
        assertNotNull(contactsLiveData);
    }
}