package com.siyuan.base.web.controller;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.web.form.SkillCardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillCardController extends WebMvcConfigurerAdapter {

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

    @PostMapping("/add")
    public String checkPersonInfo(@Valid SkillCardForm skillCardForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "参数验证不通过:" + bindingResult.getAllErrors();
        }
        String result = skillCardService.saveSkillInfo(skillCardForm);
        return result;
    }

    @PostMapping("/upload")
    public String uploadInfo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return file.getName()+","+file.getContentType()+","+file.getOriginalFilename();
    }

    @GetMapping("/queryAll")
    @CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "",methods = {})
    public List<SkillCardForm> queryAll() {
        return skillCardService.queryCurrentDayInfo();
    }
}
