package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.UserService;
import com.siyuan.base.web.request.UserRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
        //return userService.queryUser();
    }

    @PostMapping(path = "/save")
    @ResponseBody
    public void saveUserInfo(@RequestBody UserRequest userRequest){
        User user = new User();
        //user.setName(name);
        BeanUtils.copyProperties(userRequest,user);
        userRepository.save(user);
    }
    @PostMapping(path = "/save2")
    @ResponseBody
    public void saveUserInfo(@RequestParam(required = false) String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    public static void main(String[] args) {
        String[] paths = "zhousiyuan.shi.tiancai".split("\\.");
        System.out.println(paths.length);
        System.out.println(paths[0]);
    }
}

