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

package com.alaskalany.careershowcase.database;

import androidx.lifecycle.LiveData;
import com.alaskalany.careershowcase.AppExecutors;
import com.alaskalany.careershowcase.MainActivity;
import com.alaskalany.careershowcase.database.dao.ContactDao;
import com.alaskalany.careershowcase.database.dao.EducationDao;
import com.alaskalany.careershowcase.database.dao.SkillDao;
import com.alaskalany.careershowcase.database.dao.WorkDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class AppDatabaseTest {
    
    private AppDatabase appDatabase;
    
    private MainActivity mainActivity;
    
    private AppExecutors appExecutors;
    
    @Before
    public void setUp() throws Exception {
        
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        appExecutors = new AppExecutors();
        appDatabase = AppDatabase.Companion.getInstance(mainActivity, appExecutors);
    }
    
    @After
    public void tearDown() throws Exception {
        
        appDatabase = null;
    }
    
    @Test
    public void getInstance() {
        
        AppDatabase expected = appDatabase;
        AppDatabase actual = AppDatabase.Companion.getInstance(mainActivity, appExecutors);
        assertEquals(expected, actual);
    }
    
    @Test
    public void workDao() {
        
        WorkDao workDao = appDatabase.workDao();
        assertNotNull(workDao);
    }
    
    @Test
    public void skillDao() {
        
        SkillDao skillDao = appDatabase.skillDao();
        assertNotNull(skillDao);
    }
    
    @Test
    public void educationDao() {
        
        EducationDao educationDao = appDatabase.educationDao();
        assertNotNull(educationDao);
    }
    
    @Test
    public void contactDao() {
        
        ContactDao contactDao = appDatabase.contactDao();
        assertNotNull(contactDao);
    }
    
    @Test
    public void getDatabaseCreated() {
        
        LiveData<Boolean> databaseCreated = appDatabase.getDatabaseCreated();
        assertNotNull(databaseCreated);
    }
}