package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SolutionRecordService;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SolutionRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/solution")
public class SolutionRecordController {
    @Autowired
    private SolutionRecordService solutionRecordService;

    @PostMapping("/save")
    public WebResponse saveSolutionRecord(@Valid SolutionRecordForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new WebResponse("error:param","1111");
        }
        return solutionRecordService.saveSolution(form);
    }
}
