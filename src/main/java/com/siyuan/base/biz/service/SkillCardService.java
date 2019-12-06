package com.siyuan.base.biz.service;

import com.siyuan.base.web.form.SkillCardForm;

import java.util.List;

public interface SkillCardService {

    List<SkillCardForm> queryCurrentDayInfo();

    String saveSkillInfo(SkillCardForm skillCardForm);
}
