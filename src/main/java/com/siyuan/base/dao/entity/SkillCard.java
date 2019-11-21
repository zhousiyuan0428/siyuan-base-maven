package com.siyuan.base.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class SkillCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String skillPoints;
    private String skillType;
    private String skillDescribe;
    private Timestamp acquisitionTime;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;

    @Basic
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(String skillPoints) {
        this.skillPoints = skillPoints;
    }

    @Basic
    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    @Basic
    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    @Basic
    public Timestamp getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(Timestamp acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    @Basic
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillCard that = (SkillCard) o;
        return id == that.id &&
                Objects.equals(skillPoints, that.skillPoints) &&
                Objects.equals(skillType, that.skillType) &&
                Objects.equals(skillDescribe, that.skillDescribe) &&
                Objects.equals(acquisitionTime, that.acquisitionTime) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updateBy, that.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skillPoints, skillType, skillDescribe, acquisitionTime, createDate, createBy, updateDate, updateBy);
    }
}
