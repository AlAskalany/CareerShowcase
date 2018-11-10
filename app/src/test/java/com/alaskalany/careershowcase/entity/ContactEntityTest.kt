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

class ContactEntityTest {

    private var contactEntity: ContactEntity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        contactEntity = ContactEntity()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        contactEntity = null
    }

    @Test
    fun getId() {

        val expected = 123
        contactEntity!!.id = expected
        val actual = contactEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun setId() {

        val expected = 123
        contactEntity!!.id = expected
        val actual = contactEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun getTitle() {

        val expected = "E-mail"
        contactEntity!!.title = expected
        val actual = contactEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun setTitle() {

        val expected = "E-mail"
        contactEntity!!.title = expected
        val actual = contactEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun getDescription() {

        val expected = "E-mail address"
        contactEntity!!.description = expected
        val actual = contactEntity!!.description
        assertEquals(expected, actual)
    }

    @Test
    fun setDescription() {

        val expected = "E-mail address"
        contactEntity!!.title = expected
        val actual = contactEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun getLogoUrl() {

        val expected = "gs://careershowcase-96976.appspot.com/images/logo/communication/1055030 - mail.png"
        contactEntity!!.title = expected
        val actual = contactEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun setLogoUrl() {

        val expected = "gs://careershowcase-96976.appspot.com/images/logo/communication/1055030 - mail.png"
        contactEntity!!.title = expected
        val actual = contactEntity!!.title
        assertEquals(expected, actual)
    }
}