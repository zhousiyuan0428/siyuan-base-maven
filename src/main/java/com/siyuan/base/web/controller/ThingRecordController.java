package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/thingRecord")
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

    @GetMapping("/getInfo")
    public List<ThingRecordForm> getThingRecordInfo(@RequestParam("thingStatus") int thingStatus) {
        if(thingStatus == 0){
            new WebResponse("thingStatus is undefined","1111");
        }
        //这里的返回方式并不好，但是为了节约开发时间暂时处理成直接返回对象
        return thingRecordService.getThingRecordByStatus(thingStatus);
    }
}
