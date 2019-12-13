package com.siyuan.base.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "solution_record", schema = "siyuan_base_maven", catalog = "")
public class SolutionRecordEntity {
    private int id;
    private int thingId;
    private String solutionDescribe;
    private String improveWay;
    private String solutionPicture;
    private String createBy;
    private Date createData;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "solution_describe")
    public String getSolutionDescribe() {
        return solutionDescribe;
    }

    public void setSolutionDescribe(String solutionDescribe) {
        this.solutionDescribe = solutionDescribe;
    }

    @Basic
    @Column(name = "improve_way")
    public String getImproveWay() {
        return improveWay;
    }

    public void setImproveWay(String improveWay) {
        this.improveWay = improveWay;
    }

    @Basic
    @Column(name = "solution_picture")
    public String getSolutionPicture() {
        return solutionPicture;
    }

    public void setSolutionPicture(String solutionPicture) {
        this.solutionPicture = solutionPicture;
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
    @Column(name = "create_data")
    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionRecordEntity that = (SolutionRecordEntity) o;
        return id == that.id &&
                Objects.equals(solutionDescribe, that.solutionDescribe) &&
                Objects.equals(improveWay, that.improveWay) &&
                Objects.equals(solutionPicture, that.solutionPicture) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createData, that.createData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, solutionDescribe, improveWay, solutionPicture, createBy, createData);
    }

    @Basic
    @Column(name = "thing_id")
    public int getThingId() {
        return thingId;
    }

    public void setThingId(int thingId) {
        this.thingId = thingId;
    }
}
