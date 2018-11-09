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

public class ContactEntityTest {
    
    private ContactEntity contactEntity;
    
    @Before
    public void setUp() throws Exception {
        
        contactEntity = new ContactEntity();
    }
    
    @After
    public void tearDown() throws Exception {
        
        contactEntity = null;
    }
    
    @Test
    public void getId() {
        
        int expected = 123;
        contactEntity.setId(expected);
        int actual = contactEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setId() {
        
        int expected = 123;
        contactEntity.setId(expected);
        int actual = contactEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getTitle() {
        
        String expected = "E-mail";
        contactEntity.setTitle(expected);
        String actual = contactEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setTitle() {
        
        String expected = "E-mail";
        contactEntity.setTitle(expected);
        String actual = contactEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getDescription() {
        
        String expected = "E-mail address";
        contactEntity.setDescription(expected);
        String actual = contactEntity.getDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setDescription() {
        
        String expected = "E-mail address";
        contactEntity.setTitle(expected);
        String actual = contactEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getLogoUrl() {
        
        String expected = "gs://careershowcase-96976.appspot.com/images/logo/communication/1055030 - mail.png";
        contactEntity.setTitle(expected);
        String actual = contactEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setLogoUrl() {
        
        String expected = "gs://careershowcase-96976.appspot.com/images/logo/communication/1055030 - mail.png";
        contactEntity.setTitle(expected);
        String actual = contactEntity.getTitle();
        assertEquals(expected, actual);
    }
}