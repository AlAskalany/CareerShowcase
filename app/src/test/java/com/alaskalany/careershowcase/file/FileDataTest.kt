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

package com.alaskalany.careershowcase.file

import com.alaskalany.careershowcase.MainActivity
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FileDataTest {

    private var fileData: FileData? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        fileData = FileData.getInstance()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        fileData = null
    }

    @Test
    fun getInstance() {

        assertNotNull(fileData)
    }

    @Test
    fun getEducationLiveData() {

        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val educationLiveData = FileData.getEducationLiveData(mainActivity.application)
        assertNotNull(educationLiveData)
    }

    @Test
    fun getSkillsLiveData() {

        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val skillsLiveData = FileData.getSkillsLiveData(mainActivity.application)
        assertNotNull(skillsLiveData)
    }

    @Test
    fun getWorkLiveData() {

        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val workLiveData = FileData.getWorkLiveData(mainActivity.application)
        assertNotNull(workLiveData)
    }

    @Test
    fun getContactsLiveData() {

        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val contactsLiveData = FileData.getContactsLiveData(mainActivity.application)
        assertNotNull(contactsLiveData)
    }
}