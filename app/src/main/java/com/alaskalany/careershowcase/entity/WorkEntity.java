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

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.model.Work;

/**
 * A contact item representing a piece of description.
 */
@Entity(tableName = "works_table")
public class WorkEntity
        implements Work {
    
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "work_id")
    private int id;
    
    @ColumnInfo(name = "work_title")
    private String title;
    
    @ColumnInfo(name = "work_description")
    private String description;
    
    @ColumnInfo(name = "work_company")
    private String company;
    
    @ColumnInfo(name = "work_location")
    private String location;
    
    @ColumnInfo(name = "work_duration")
    private String duration;
    
    @ColumnInfo(name = "work_logo_url")
    private String logoUrl;
    
    public WorkEntity() {
    
    }
    
    @Override
    public int getId() {
        
        return id;
    }
    
    @Override
    public void setId(int id) {
        
        this.id = id;
    }
    
    @Override
    public String getDescription() {
        
        return description;
    }
    
    @Override
    public void setDescription(String description) {
        
        this.description = description;
    }
    
    @Override
    public String getDuration() {
        
        return duration;
    }
    
    @Override
    public void setDuration(String duration) {
        
        this.duration = duration;
    }
    
    @Override
    public String getCompany() {
        
        return company;
    }
    
    @Override
    public void setCompany(String company) {
        
        this.company = company;
    }
    
    @Override
    public String getTitle() {
        
        return title;
    }
    
    @Override
    public void setTitle(String title) {
        
        this.title = title;
    }
    
    @Override
    public String getLocation() {
        
        return location;
    }
    
    @Override
    public void setLocation(String location) {
        
        this.location = location;
    }
    
    @Override
    public String getLogoUrl() {
        
        return logoUrl;
    }
    
    @Override
    public void setLogoUrl(String logoUrl) {
        
        this.logoUrl = logoUrl;
    }
}
