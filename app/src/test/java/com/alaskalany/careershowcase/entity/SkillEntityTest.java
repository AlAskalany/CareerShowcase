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

package com.alaskalany.careershowcase.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SkillEntityTest {
    
    private static final int ID = 123;
    
    private static final String TITLE = "Java";
    
    private static final String LOGO_URL =
            "https://firebasestorage.googleapis.com/v0/b/careershowcase-96976.appspot.com/o/images%2Flogo%2Fschool%2Famit_logo.png?alt=media&token=86499d5f-def9-4c8d-8d13-bc14b53b78db";
    
    private SkillEntity skillEntity;
    
    @Before
    public void setUp() throws Exception {
        
        skillEntity = new SkillEntity();
    }
    
    @After
    public void tearDown() throws Exception {
        
        skillEntity = null;
    }
    
    @Test
    public void getId() {
        
        int expected = ID;
        skillEntity.setId(expected);
        int actual = skillEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setId() {
        
        int expected = ID;
        skillEntity.setId(expected);
        int actual = skillEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getTitle() {
        
        String expected = TITLE;
        skillEntity.setTitle(expected);
        String actual = skillEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setTitle() {
        
        String expected = TITLE;
        skillEntity.setTitle(expected);
        String actual = skillEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getLevel() {
        
        int expected = 1;
        skillEntity.setLevel(expected);
        int actual = skillEntity.getLevel();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setLevel() {
        
        int expected = 1;
        skillEntity.setLevel(expected);
        int actual = skillEntity.getLevel();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getLogoUrl() {
        
        String expected = LOGO_URL;
        skillEntity.setLogoUrl(expected);
        String actual = skillEntity.getLogoUrl();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setLogoUrl() {
        
        String expected = LOGO_URL;
        skillEntity.setLogoUrl(expected);
        String actual = skillEntity.getLogoUrl();
        assertEquals(expected, actual);
    }
}