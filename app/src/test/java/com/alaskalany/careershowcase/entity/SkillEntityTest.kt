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

package com.alaskalany.careershowcase.entity

import org.junit.After
import org.junit.Before
import org.junit.Test

import junit.framework.TestCase.assertEquals

class SkillEntityTest {

    private var skillEntity: SkillEntity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        skillEntity = SkillEntity()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        skillEntity = null
    }

    @Test
    fun getId() {

        val expected = ID
        skillEntity!!.id = expected
        val actual = skillEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun setId() {

        val expected = ID
        skillEntity!!.id = expected
        val actual = skillEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun getTitle() {

        val expected = TITLE
        skillEntity!!.title = expected
        val actual = skillEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun setTitle() {

        val expected = TITLE
        skillEntity!!.title = expected
        val actual = skillEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun getLevel() {

        val expected = 1
        skillEntity!!.level = expected
        val actual = skillEntity!!.level
        assertEquals(expected, actual)
    }

    @Test
    fun setLevel() {

        val expected = 1
        skillEntity!!.level = expected
        val actual = skillEntity!!.level
        assertEquals(expected, actual)
    }

    @Test
    fun getLogoUrl() {

        val expected = LOGO_URL
        skillEntity!!.logoUrl = expected
        val actual = skillEntity!!.logoUrl
        assertEquals(expected, actual)
    }

    @Test
    fun setLogoUrl() {

        val expected = LOGO_URL
        skillEntity!!.logoUrl = expected
        val actual = skillEntity!!.logoUrl
        assertEquals(expected, actual)
    }

    companion object {

        private val ID = 123

        private val TITLE = "Java"

        private val LOGO_URL = "https://firebasestorage.googleapis.com/v0/b/careershowcase-96976.appspot.com/o/images%2Flogo%2Fschool%2Famit_logo.png?alt=media&token=86499d5f-def9-4c8d-8d13-bc14b53b78db"
    }
}