package com.siyuan.base.dao.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private String sex;

}
