package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.dao.entity.SkillCardEntity;
import com.siyuan.base.web.form.SkillCardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@RestController
@RequestMapping("/skill")
public class SkillCardController extends WebMvcConfigurerAdapter{

    @Autowired
    private SkillCardService skillCardService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(SkillCardForm skillCardForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid SkillCardForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/index";
    }
    @GetMapping("/queryAll")
    @CrossOrigin
    public Iterable<SkillCardEntity> queryAll(){
        return skillCardService.queryAll();
    }
}
