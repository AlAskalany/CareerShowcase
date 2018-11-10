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

class EducationEntityTest {

    private var educationEntity: EducationEntity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        educationEntity = EducationEntity()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

        educationEntity = null
    }

    @Test
    fun getId() {

        val expected = ID
        educationEntity!!.id = expected
        val actual = educationEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun setId() {

        val expected = ID
        educationEntity!!.id = expected
        val actual = educationEntity!!.id
        assertEquals(expected, actual)
    }

    @Test
    fun getTitle() {

        val expected = TITLE
        educationEntity!!.title = expected
        val actual = educationEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun setTitle() {

        val expected = TITLE
        educationEntity!!.title = expected
        val actual = educationEntity!!.title
        assertEquals(expected, actual)
    }

    @Test
    fun getDegree() {

        val expected = DEGREE
        educationEntity!!.degree = expected
        val actual = educationEntity!!.degree
        assertEquals(expected, actual)
    }

    @Test
    fun setDegree() {

        val expected = DEGREE
        educationEntity!!.degree = expected
        val actual = educationEntity!!.degree
        assertEquals(expected, actual)
    }

    @Test
    fun getStudyField() {

        val expected = STUDY_FIELD
        educationEntity!!.studyField = expected
        val actual = educationEntity!!.studyField
        assertEquals(expected, actual)
    }

    @Test
    fun setStudyField() {

        val expected = STUDY_FIELD
        educationEntity!!.studyField = expected
        val actual = educationEntity!!.studyField
        assertEquals(expected, actual)
    }

    @Test
    fun getDescription() {

        val expected = DESCRIPTION
        educationEntity!!.description = expected
        val actual = educationEntity!!.description
        assertEquals(expected, actual)
    }

    @Test
    fun setDescription() {

        val expected = DESCRIPTION
        educationEntity!!.description = expected
        val actual = educationEntity!!.description
        assertEquals(expected, actual)
    }

    @Test
    fun getInstitution() {

        val expected = INSTITUTION
        educationEntity!!.institution = expected
        val actual = educationEntity!!.institution
        assertEquals(expected, actual)
    }

    @Test
    fun setInstitution() {

        val expected = INSTITUTION
        educationEntity!!.institution = expected
        val actual = educationEntity!!.institution
        assertEquals(expected, actual)
    }

    @Test
    fun getLocation() {

        val expected = LOCATION
        educationEntity!!.location = expected
        val actual = educationEntity!!.location
        assertEquals(expected, actual)
    }

    @Test
    fun setLocation() {

        val expected = LOCATION
        educationEntity!!.location = expected
        val actual = educationEntity!!.location
        assertEquals(expected, actual)
    }

    @Test
    fun getDuration() {

        val expected = DURATION
        educationEntity!!.duration = expected
        val actual = educationEntity!!.duration
        assertEquals(expected, actual)
    }

    @Test
    fun setDuration() {

        val expected = DURATION
        educationEntity!!.duration = expected
        val actual = educationEntity!!.duration
        assertEquals(expected, actual)
    }

    @Test
    fun getLogoUrl() {

        val expected = LOGO_URL
        educationEntity!!.logoUrl = expected
        val actual = educationEntity!!.logoUrl
        assertEquals(expected, actual)
    }

    @Test
    fun setLogoUrl() {

        val expected = LOGO_URL
        educationEntity!!.logoUrl = expected
        val actual = educationEntity!!.logoUrl
        assertEquals(expected, actual)
    }

    companion object {

        private val ID = 123

        private val TITLE = "MSc in Master of Science"

        private val DEGREE = "Master of Science"

        private val STUDY_FIELD = "Nanotechnology"

        private val DESCRIPTION = "I have a B.Sc. in Electrical and Computer Engineering and studied for a M.Sc. in Nanotechnology. Worked in the software industry for 2 years, in Quality Assurance and Mobile App Development. My primary fields of expertise is Java development for Android applications and building mobile back-ends using Firebase and Google Cloud Platform.\n" +
                "\n" +
                "My goal is to work on building quality Android applications with reliable back-end services, and to become a world-class expert in this specialty. I combine my educational background and technical skills with a broad knowledge of various technologies to come up with highly efficient and cost-effective solutions. Through motivation and high work ethic, I create and thrive in an environment of collaboration and eagerness to achieve set goals."

        private val INSTITUTION = "KTH Royal Institute of Technology"

        private val LOCATION = "Cairo, Egypt"

        private val DURATION = "August 2014 - September 2018"

        private val LOGO_URL = "https://firebasestorage.googleapis.com/v0/b/careershowcase-96976.appspot.com/o/images%2Flogo%2Fschool%2Famit_logo.png?alt=media&token=86499d5f-def9-4c8d-8d13-bc14b53b78db"
    }
}