package com.siyuan.base.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "skill_card", schema = "siyuan_base_maven", catalog = "")
public class SkillCardEntity {
    private int id;
    private String skillPoints;
    private String skillType;
    private String skillDescribe;
    private Date acquisitionTime;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public void setAcquisitionTime(Timestamp acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "skill_points")
    public String getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(String skillPoints) {
        this.skillPoints = skillPoints;
    }

    @Basic
    @Column(name = "skill_type")
    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    @Basic
    @Column(name = "skill_describe")
    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "acquisition_time")
    public Date getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(Date acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillCardEntity that = (SkillCardEntity) o;
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
