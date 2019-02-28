package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.User;
import com.siyuan.base.dao.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Log
public class UserService {

    @Resource
    private UserRepository userRepository;

    public Iterable<User> queryUser(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }
}
