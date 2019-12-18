package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.SkillCardForm;

import java.util.List;

public interface SkillCardService {

    List<SkillCardForm> queryCurrentDayInfo();

    WebResponse saveSkillInfo(SkillCardForm skillCardForm);

    void saveSkillInfo(ThingRecordEntity entity);
}
