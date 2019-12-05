package com.siyuan.base.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class SkillCardForm {
    @NotNull
    @Size(min=0 , max=9)
    private String skillPoints;
    @NotNull
    private String skillType;
    @NotNull
    private String skillDescribe;
    private Timestamp acquisitionTime;

    public String getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(String skillPoints) {
        this.skillPoints = skillPoints;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    public Timestamp getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(Timestamp acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    @Override
    public String toString() {
        return "SkillCardForm{" +
                "skillPoints='" + skillPoints + '\'' +
                ", skillType='" + skillType + '\'' +
                ", skillDescribe='" + skillDescribe + '\'' +
                ", acquisitionTime=" + acquisitionTime +
                '}';
    }
}
