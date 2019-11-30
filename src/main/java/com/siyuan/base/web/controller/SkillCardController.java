package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SkillCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class SkillCardController {

    @Autowired
    private SkillCardService skillCardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAccounts() {
        System.out.println(skillCardService.saveSkillInfo());
        return "index";
    }

}
