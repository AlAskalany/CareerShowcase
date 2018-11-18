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
import com.alaskalany.careershowcase.model.Skill;

/**
 * A skill item representing a piece of description.
 */
@Entity(tableName = "skills_table")
public class SkillEntity implements Skill {
    
    /**
     *
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skill_id")
    private int id;
    
    /**
     *
     */
    @ColumnInfo(name = "skill_title")
    private String title;
    
    @ColumnInfo(name = "skill_level")
    private int level;
    
    @ColumnInfo(name = "skill_log_url")
    private String logoUrl;
    
    /**
     *
     */
    @SuppressWarnings("WeakerAccess")
    public SkillEntity() {
    
    }
    
    /**
     * @return
     */
    @Override
    public int getId() {
        
        return id;
    }
    
    /**
     * @param pSkillId
     */
    @Override
    public void setId(int pSkillId) {
        
        this.id = pSkillId;
    }
    
    /**
     * @return
     */
    @Override
    public String getTitle() {
        
        return title;
    }
    
    /**
     * @param title
     */
    @Override
    public void setTitle(String title) {
        
        this.title = title;
    }
    
    @Override
    public int getLevel() {
        
        return level;
    }
    
    @Override
    public void setLevel(int pLevel) {
        
        level = pLevel;
    }
    
    @Override
    public String getLogoUrl() {
        
        return logoUrl;
    }
    
    @Override
    public void setLogoUrl(String photoUrl) {
        
        this.logoUrl = photoUrl;
    }
}
