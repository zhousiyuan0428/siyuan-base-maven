package com.siyuan.base.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Familytree {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected int id;

    protected int sid;

    protected int parentId;

    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "id=" + id +
                ", sid=" + sid +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }
}
