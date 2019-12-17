package com.siyuan.base.web.form;

public class ThingRecordForm {

    private int id;
    private String skillType;
    private String thingDescribe;
    private String thingPicture;
    private Double spendTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getThingDescribe() {
        return thingDescribe;
    }

    public void setThingDescribe(String thingDescribe) {
        this.thingDescribe = thingDescribe;
    }

    public String getThingPicture() {
        return thingPicture;
    }

    public void setThingPicture(String thingPicture) {
        this.thingPicture = thingPicture;
    }

    public Double getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Double spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public String toString() {
        return "ThingRecordForm{" +
                "id=" + id +
                ", skillType='" + skillType + '\'' +
                ", thingDescribe='" + thingDescribe + '\'' +
                ", thingPicture='" + thingPicture + '\'' +
                ", spendTime=" + spendTime +
                '}';
    }
}
