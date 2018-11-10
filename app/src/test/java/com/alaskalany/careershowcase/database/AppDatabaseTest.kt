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

package com.alaskalany.careershowcase.database

import com.alaskalany.careershowcase.AppExecutors
import com.alaskalany.careershowcase.MainActivity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AppDatabaseTest {

    private var appDatabase: AppDatabase? = null

    private var mainActivity: MainActivity? = null

    private var appExecutors: AppExecutors? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        appExecutors = AppExecutors()
        appDatabase = AppDatabase.getInstance(mainActivity!!, appExecutors!!)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        appDatabase = null
    }

    @Test
    fun getInstance() {

        val expected = appDatabase
        val actual = AppDatabase.getInstance(mainActivity!!, appExecutors!!)
        assertEquals(expected, actual)
    }

    @Test
    fun workDao() {

        val workDao = appDatabase!!.workDao()
        assertNotNull(workDao)
    }

    @Test
    fun skillDao() {

        val skillDao = appDatabase!!.skillDao()
        assertNotNull(skillDao)
    }

    @Test
    fun educationDao() {

        val educationDao = appDatabase!!.educationDao()
        assertNotNull(educationDao)
    }

    @Test
    fun contactDao() {

        val contactDao = appDatabase!!.contactDao()
        assertNotNull(contactDao)
    }

    @Test
    fun getDatabaseCreated() {

        val databaseCreated = appDatabase!!.databaseCreated
        assertNotNull(databaseCreated)
    }
}