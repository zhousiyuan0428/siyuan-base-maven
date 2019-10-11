package com.siyuan.base.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sentiment_realtime_comment", schema="RECORDS")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int realtimeId;

    private String userName;

    private int hotNum;

    private Date publishData;
}
