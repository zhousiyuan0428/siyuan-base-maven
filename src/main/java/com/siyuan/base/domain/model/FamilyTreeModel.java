package com.siyuan.base.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class FamilyTreeModel {

    protected int sid;

    protected int parentId;

    protected String name;

    protected List<FamilyTreeModel> children;
}
