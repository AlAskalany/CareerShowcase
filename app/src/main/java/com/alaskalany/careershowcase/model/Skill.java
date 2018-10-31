package com.alaskalany.careershowcase.model;

public interface Skill
        extends Model {

    int getSkillId();

    void setSkillId(int id);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);
}
