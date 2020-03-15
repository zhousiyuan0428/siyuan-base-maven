package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.SkillCardEntity;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.web.form.SkillCardForm;
import com.siyuan.base.web.form.SkillEchartForm;

import java.util.List;

public interface SkillCardService {

    List<SkillCardForm> queryCurrentDayInfo();

    void saveSkillInfo(SkillCardEntity entity);

    List<SkillEchartForm>  querySevenDayInfo();
}
