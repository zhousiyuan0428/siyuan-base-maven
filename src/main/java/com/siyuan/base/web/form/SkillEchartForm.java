package com.siyuan.base.web.form;

import com.siyuan.base.dao.entity.SkillCardEntity;

import java.util.List;

public class SkillEchartForm {
    private String name;
    private List<SkillCardEntity> skillCardEntities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillCardEntity> getSkillCardEntities() {
        return skillCardEntities;
    }

    public void setSkillCardEntities(List<SkillCardEntity> skillCardEntities) {
        this.skillCardEntities = skillCardEntities;
    }
}
