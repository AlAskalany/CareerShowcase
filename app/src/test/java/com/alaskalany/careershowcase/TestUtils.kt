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

import android.view.View
import androidx.fragment.app.FragmentActivity

internal object TestUtils {

    @JvmStatic
    fun clickOn(activity: FragmentActivity, viewId: Int) {

        activity.findViewById<View>(viewId)
                .performClick()
    }

    @JvmStatic
    fun isCurrentFragment(activity: FragmentActivity, expectedFragmentClass: Class<*>): Boolean {

        val currentFragmentClass = getFragmentClass(activity, R.id.container_navigation)

        return expectedFragmentClass == currentFragmentClass
    }

    @JvmStatic
    fun getFragmentClass(activity: FragmentActivity, containerViewId: Int): Class<*> {

        return activity.supportFragmentManager
                .findFragmentById(containerViewId)!!.javaClass
    }

    @JvmStatic
    fun pressBack(activity: FragmentActivity) {

        activity.onBackPressed()
    }
}
