package com.siyuan.base.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "thing_record", schema = "siyuan_base_maven")
public class ThingRecordEntity {
    private long id;
    private String skillType;
    private String thingDescribe;
    private String thingPicture;
    private Double spendTime;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private int thingStatus;
    private Integer relationId;

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "thing_describe")
    public String getThingDescribe() {
        return thingDescribe;
    }

    public void setThingDescribe(String thingDescribe) {
        this.thingDescribe = thingDescribe;
    }

    @Basic
    @Column(name = "thing_picture")
    public String getThingPicture() {
        return thingPicture;
    }

    public void setThingPicture(String thingPicture) {
        this.thingPicture = thingPicture;
    }

    @Basic
    @Column(name = "spend_time")
    public Double getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Double spendTime) {
        this.spendTime = spendTime;
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
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThingRecordEntity that = (ThingRecordEntity) o;
        return id == that.id &&
                Objects.equals(skillType, that.skillType) &&
                Objects.equals(thingDescribe, that.thingDescribe) &&
                Objects.equals(thingPicture, that.thingPicture) &&
                Objects.equals(spendTime, that.spendTime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skillType, thingDescribe, thingPicture, spendTime, createBy, createTime, updateBy, updateTime);
    }

    @Basic
    @Column(name = "thing_status")
    public int getThingStatus() {
        return thingStatus;
    }

    public void setThingStatus(int thingStatus) {
        this.thingStatus = thingStatus;
    }

    @Basic
    @Column(name = "relation_id")
    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    @Override
    public String toString() {
        return "ThingRecordEntity{" +
                "id=" + id +
                ", skillType='" + skillType + '\'' +
                ", thingDescribe='" + thingDescribe + '\'' +
                ", thingPicture='" + thingPicture + '\'' +
                ", spendTime=" + spendTime +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", thingStatus=" + thingStatus +
                ", relationId=" + relationId +
                '}';
    }
}
