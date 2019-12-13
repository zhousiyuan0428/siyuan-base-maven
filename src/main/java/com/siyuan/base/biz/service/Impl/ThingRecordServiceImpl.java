package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ThingRecordServiceImpl implements ThingRecordService {

    @Autowired
    private ThingRecordRepository thingRecordRepository;

    @Override
    public WebResponse save(ThingRecordForm thingRecordForm) {
        ThingRecordEntity entity = new ThingRecordEntity();
        BeanUtils.copyProperties(thingRecordForm,entity);
        entity.setCreateBy("周思远");
        entity.setCreateTime(new Date());
        thingRecordRepository.save(entity);
        return new WebResponse("success","0000");
    }

    @Override
    public ThingRecordForm getOneQuestion() {
        ThingRecordEntity entity = thingRecordRepository.getOneQuestion();
        ThingRecordForm form = new ThingRecordForm();
        BeanUtils.copyProperties(entity,form);
        return form;
    }
}
