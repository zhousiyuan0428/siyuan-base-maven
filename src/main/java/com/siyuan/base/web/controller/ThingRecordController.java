package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SolutionRecordService;
import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SolutionRecordForm;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/question")
public class ThingRecordController {

    @Autowired
    private ThingRecordService thingRecordService;

    @PostMapping("/add")
    public WebResponse checkPersonInfo(@Valid ThingRecordForm thingRecordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new WebResponse("error", bindingResult.getAllErrors()+"");
        }
        return  thingRecordService.save(thingRecordForm);
    }

    @PostMapping("/upload")
    public String uploadInfo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return file.getName()+","+file.getContentType()+","+file.getOriginalFilename();
    }

    @GetMapping("/getOneQuestion")
    public ThingRecordForm getOneQuestion() {
        return thingRecordService.getOneQuestion();
    }
}
