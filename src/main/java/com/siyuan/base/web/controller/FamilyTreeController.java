package com.siyuan.base.web.controller;

import com.siyuan.base.dao.repository.FamilyTreeRepository;
import com.siyuan.base.dao.entity.Familytree;
import com.siyuan.base.domain.model.FamilyTreeModel;
import com.siyuan.base.domain.service.FamilyTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/family")
public class FamilyTreeController {

    @Autowired
    private FamilyTreeRepository familyTreeRepository;
    @Autowired
    private FamilyTreeService familyTreeService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Familytree> getAllUsers() {
        return familyTreeRepository.findAll();
    }

    @GetMapping(path = "/orderByTree")
    @ResponseBody
    public FamilyTreeModel getInfoOrderByTree() {
        return familyTreeService.getTreeInfo();
    }

}
