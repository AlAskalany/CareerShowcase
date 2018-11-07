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

package com.alaskalany.careershowcase;

import com.alaskalany.careershowcase.ui.contact.ContactListFragment;
import com.alaskalany.careershowcase.ui.education.EducationListFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment;
import com.alaskalany.careershowcase.ui.work.WorkListFragment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static com.alaskalany.careershowcase.TestUtils.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private static final String TAG = "MainActivityTest";

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {

        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }

    @Test
    public void clickOnEducationAttachesEducationListFragment() {

        clickOn(mainActivity, R.id.navigation_education);

        Class<?> expected = EducationListFragment.class;

        Class<?> actual = getFragmentClass(mainActivity, R.id.container_navigation);
        assertEquals(expected, actual);
    }

    @Test
    public void clickOnWorkAttachesWorkListFragment() {

        clickOn(mainActivity, R.id.navigation_work);

        assertTrue(isCurrentFragment(mainActivity, WorkListFragment.class));
    }

    @Test
    public void clickOnSkillsAttachesSkillListFragment() {

        clickOn(mainActivity, R.id.navigation_skills);

        assertTrue(isCurrentFragment(mainActivity, SkillListFragment.class));
    }

    @Test
    public void clickOnContactAttachesContactListFragment() {

        clickOn(mainActivity, R.id.navigation_contact);

        assertTrue(isCurrentFragment(mainActivity, ContactListFragment.class));
    }

    @Test
    public void clickOnBackInEducationAttachesOverviewFragment() {

        clickOn(mainActivity, R.id.navigation_education);

        assertTrue(isCurrentFragment(mainActivity, EducationListFragment.class));

        pressBack(mainActivity);

        assertTrue(isCurrentFragment(mainActivity, OverviewFragment.class));
    }

    @Test
    public void clickOnBackInWorkAttachesOverviewFragment() {

        clickOn(mainActivity, R.id.navigation_work);

        assertTrue(isCurrentFragment(mainActivity, WorkListFragment.class));

        pressBack(mainActivity);

        assertTrue(isCurrentFragment(mainActivity, OverviewFragment.class));
    }

    @Test
    public void clickOnBackInSkillsAttachesOverviewFragment() {

        clickOn(mainActivity, R.id.navigation_skills);

        assertTrue(isCurrentFragment(mainActivity, SkillListFragment.class));

        pressBack(mainActivity);

        assertTrue(isCurrentFragment(mainActivity, OverviewFragment.class));
    }

    @Test
    public void clickOnBackInContactAttachesOverviewFragment() {

        clickOn(mainActivity, R.id.navigation_contact);

        assertTrue(isCurrentFragment(mainActivity, ContactListFragment.class));

        pressBack(mainActivity);

        assertTrue(isCurrentFragment(mainActivity, OverviewFragment.class));
    }
}