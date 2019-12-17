package com.siyuan.base.web.form;

public class SkillCardForm {

    private String skillPoints;
    private String skillType;
    private String skillDescribe;
    private String acquisitionTime;

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

    public String getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(String acquisitionTime) {
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
