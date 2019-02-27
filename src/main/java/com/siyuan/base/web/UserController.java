package com.siyuan.base.web;

import com.siyuan.base.biz.UserRepository;
import com.siyuan.base.dao.entity.User;
import com.siyuan.base.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.invoke.empty.Empty;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers(@RequestParam String name) {
        if (name.isEmpty()) {
            //Jpa
            //return userRepository.findAll();
            //mybatis-starter
            return userMapper.getAll();
        } else if(name.equals("temp")){
            return userMapper.selectUserByName1(name);
        }else{
            return userMapper.selectUserByName(name);
        }

    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if (userRepository.findAllByNameEquals(name).isEmpty()) {
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
            return "Saved";
        } else {
            return "Duplicate User Count!";
        }

    }
}
