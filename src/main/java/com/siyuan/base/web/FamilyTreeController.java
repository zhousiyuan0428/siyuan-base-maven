package com.siyuan.base.web;

import com.siyuan.base.biz.FamilyTreeRepository;
import com.siyuan.base.dao.entity.Familytree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/family")
public class FamilyTreeController {

    @Autowired
    private FamilyTreeRepository familyTreeRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Familytree> getAllUsers() {
        return familyTreeRepository.findAll();
    }

    @GetMapping(path="/orderByTree")
    public @ResponseBody
    Iterable<Familytree> getInfoOrderByTree() {
        return familyTreeRepository.findAll();
    }

}
