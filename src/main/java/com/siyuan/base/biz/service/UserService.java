package com.siyuan.base.biz.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> queryUser(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }
}
