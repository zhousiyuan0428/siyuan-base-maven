package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.User;
import com.siyuan.base.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public Iterable<User> queryUser(){
        System.out.println("查询开始");
        Iterable<User> users = userRepository.findAll();
        for (User user : users){
            System.out.println(user);
        }
        return userRepository.findAll();
    }
}
