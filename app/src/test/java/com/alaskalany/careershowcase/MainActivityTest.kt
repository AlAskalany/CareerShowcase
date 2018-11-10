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

package com.alaskalany.careershowcase

import com.alaskalany.careershowcase.ui.contact.ContactListFragment
import com.alaskalany.careershowcase.ui.education.EducationListFragment
import com.alaskalany.careershowcase.ui.overview.OverviewFragment
import com.alaskalany.careershowcase.ui.skills.SkillListFragment
import com.alaskalany.careershowcase.ui.work.WorkListFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

import com.alaskalany.careershowcase.TestUtils.clickOn
import com.alaskalany.careershowcase.TestUtils.isCurrentFragment
import com.alaskalany.careershowcase.TestUtils.getFragmentClass
import com.alaskalany.careershowcase.TestUtils.pressBack
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private var mainActivity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        mainActivity = null
    }

    @Test
    fun clickOnEducationAttachesEducationListFragment() {

        clickOn(mainActivity!!, R.id.navigation_education)

        val expected = EducationListFragment::class.java

        val actual = getFragmentClass(mainActivity!!, R.id.container_navigation)
        assertEquals(expected, actual)
    }

    @Test
    fun clickOnWorkAttachesWorkListFragment() {

        clickOn(mainActivity!!, R.id.navigation_work)

        assertTrue(isCurrentFragment(mainActivity!!, WorkListFragment::class.java))
    }

    @Test
    fun clickOnSkillsAttachesSkillListFragment() {

        clickOn(mainActivity!!, R.id.navigation_skills)

        assertTrue(isCurrentFragment(mainActivity!!, SkillListFragment::class.java))
    }

    @Test
    fun clickOnContactAttachesContactListFragment() {

        clickOn(mainActivity!!, R.id.navigation_contact)

        assertTrue(isCurrentFragment(mainActivity!!, ContactListFragment::class.java))
    }

    @Test
    fun clickOnBackInEducationAttachesOverviewFragment() {

        clickOn(mainActivity!!, R.id.navigation_education)

        assertTrue(isCurrentFragment(mainActivity!!, EducationListFragment::class.java))

        pressBack(mainActivity!!)

        assertTrue(isCurrentFragment(mainActivity!!, OverviewFragment::class.java))
    }

    @Test
    fun clickOnBackInWorkAttachesOverviewFragment() {

        clickOn(mainActivity!!, R.id.navigation_work)

        assertTrue(isCurrentFragment(mainActivity!!, WorkListFragment::class.java))

        pressBack(mainActivity!!)

        assertTrue(isCurrentFragment(mainActivity!!, OverviewFragment::class.java))
    }

    @Test
    fun clickOnBackInSkillsAttachesOverviewFragment() {

        clickOn(mainActivity!!, R.id.navigation_skills)

        assertTrue(isCurrentFragment(mainActivity!!, SkillListFragment::class.java))

        pressBack(mainActivity!!)

        assertTrue(isCurrentFragment(mainActivity!!, OverviewFragment::class.java))
    }

    @Test
    fun clickOnBackInContactAttachesOverviewFragment() {

        clickOn(mainActivity!!, R.id.navigation_contact)

        assertTrue(isCurrentFragment(mainActivity!!, ContactListFragment::class.java))

        pressBack(mainActivity!!)

        assertTrue(isCurrentFragment(mainActivity!!, OverviewFragment::class.java))
    }

    companion object {

        private val TAG = "MainActivityTest"
    }
}