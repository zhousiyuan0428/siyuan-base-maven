package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.web.form.SkillCardForm;
import com.siyuan.base.web.form.SkillEchartForm;

import java.util.List;

public interface SkillCardService {

    List<SkillCardForm> queryCurrentDayInfo();

    void saveSkillInfo(ThingRecordEntity entity);

    List<SkillEchartForm>  querySevenDayInfo();
}
