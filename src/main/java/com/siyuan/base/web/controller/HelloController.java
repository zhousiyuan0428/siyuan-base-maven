package com.siyuan.base.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Partrick Zhou,  May I Help you?";
    }

}
