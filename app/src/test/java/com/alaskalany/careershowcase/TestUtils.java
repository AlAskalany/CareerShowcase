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

import androidx.fragment.app.FragmentActivity;

class TestUtils {

    static void clickOn(FragmentActivity activity, int viewId) {

        activity.findViewById(viewId)
                .performClick();
    }

    public static boolean isCurrentFragment(FragmentActivity activity, Class<?> expectedFragmentClass) {

        Class<?> currentFragmentClass = getFragmentClass(activity, R.id.container_navigation);

        return expectedFragmentClass == currentFragmentClass;
    }

    static Class<?> getFragmentClass(FragmentActivity activity, int containerViewId) {

        return activity.getSupportFragmentManager()
                       .findFragmentById(containerViewId)
                       .getClass();
    }

    static void pressBack(FragmentActivity activity) {

        activity.onBackPressed();
    }
}
