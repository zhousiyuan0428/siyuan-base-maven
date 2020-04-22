package com.siyuan.base.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
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
    private long relationId;
    private String solutionDescribe;
}
