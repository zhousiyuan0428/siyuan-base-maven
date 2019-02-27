package com.siyuan.base.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected int id;

    protected String createdBy;

    protected Date createdDate;

    protected String updatedBy;

    protected Date updatedDate;

    protected String sid;

    protected String clothesName;

    protected String cloth;

    protected String pruchaseDate;

    protected String pruchasePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    public String getPruchaseDate() {
        return pruchaseDate;
    }

    public void setPruchaseDate(String pruchaseDate) {
        this.pruchaseDate = pruchaseDate;
    }

    public String getPruchasePrice() {
        return pruchasePrice;
    }

    public void setPruchasePrice(String pruchasePrice) {
        this.pruchasePrice = pruchasePrice;
    }
}
