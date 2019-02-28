package com.siyuan.base.web.request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;

    private Integer age;

    private String email;

    private String sex;
}
