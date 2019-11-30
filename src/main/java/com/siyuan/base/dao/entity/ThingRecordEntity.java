package com.siyuan.base.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "thing_record", schema = "siyuan_base_maven")
public class ThingRecordEntity {
    private int id;
    private String thingResume;
    private String thingDescride;
    private Double spendTime;
    private String createBy;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "thing_resume")
    public String getThingResume() {
        return thingResume;
    }

    public void setThingResume(String thingResume) {
        this.thingResume = thingResume;
    }

    @Basic
    @Column(name = "thing_descride")
    public String getThingDescride() {
        return thingDescride;
    }

    public void setThingDescride(String thingDescride) {
        this.thingDescride = thingDescride;
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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThingRecordEntity that = (ThingRecordEntity) o;
        return id == that.id &&
                Objects.equals(thingResume, that.thingResume) &&
                Objects.equals(thingDescride, that.thingDescride) &&
                Objects.equals(spendTime, that.spendTime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thingResume, thingDescride, spendTime, createBy, createTime, updateBy, updateTime);
    }
}
