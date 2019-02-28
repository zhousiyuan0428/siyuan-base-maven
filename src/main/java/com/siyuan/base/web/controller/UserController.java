package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.UserService;
import com.siyuan.base.dao.entity.User;
import com.siyuan.base.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        //return userRepository.findAll();
        return userService.queryUser();
    }

}
