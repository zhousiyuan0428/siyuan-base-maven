package com.siyuan.base.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SkillCardEntity {
    private int id;
    private String skillPoints;
    private String skillType;
    private String skillTypeFlag;
    private String skillDescribe;
    private Date acquisitionTime;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

}
