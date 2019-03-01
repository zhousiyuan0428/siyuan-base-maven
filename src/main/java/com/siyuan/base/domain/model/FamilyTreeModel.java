package com.siyuan.base.domain.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class FamilyTreeModel {

    protected int sid;

    protected int parentId;

    protected String name;
}
