package com.siyuan.base.web;

import com.siyuan.base.biz.ClothesRepository;
import com.siyuan.base.biz.UserRepository;
import com.siyuan.base.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/clothes")
public class ClothesController {

    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if(userRepository.findAllByNameEquals(name).isEmpty()) {
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);
            return "Saved";
        }else{
            return "Duplicate User Count!";
        }

    }
}
