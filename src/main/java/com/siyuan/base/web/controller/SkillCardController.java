package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SkillCardForm;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillCardController extends WebMvcConfigurerAdapter {

    @Autowired
    private SkillCardService skillCardService;

    @GetMapping("/queryAll")
    public List<SkillCardForm> queryAll() {
        return skillCardService.queryCurrentDayInfo();
    }

    @PostMapping("/add")
    public WebResponse checkPersonInfo(@Valid SkillCardForm skillCardForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new WebResponse("error", bindingResult.getAllErrors()+"");
        }
        return skillCardService.saveSkillInfo(skillCardForm);
    }

}
