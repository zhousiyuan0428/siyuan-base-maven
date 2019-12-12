package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/question")
public class ThingRecordController {

    @Autowired
    private ThingRecordService thingRecordService;

    @PostMapping("/add")
    public String checkPersonInfo(@Valid ThingRecordForm thingRecordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "参数验证不通过:" + bindingResult.getAllErrors();
        }
        String result = thingRecordService.save(thingRecordForm);
        return result;
    }

    @PostMapping("/upload")
    public String uploadInfo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return file.getName()+","+file.getContentType()+","+file.getOriginalFilename();
    }

    @GetMapping("/queryAll")
    public List<ThingRecordForm> queryAll() {
        return thingRecordService.queryAll();
    }
}
