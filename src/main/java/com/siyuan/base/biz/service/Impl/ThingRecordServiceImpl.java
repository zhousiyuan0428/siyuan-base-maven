package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ThingRecordServiceImpl implements ThingRecordService {

    @Autowired
    private ThingRecordRepository thingRecordRepository;

    @Override
    public String save(ThingRecordForm thingRecordForm) {
        ThingRecordEntity entity = new ThingRecordEntity();
        BeanUtils.copyProperties(thingRecordForm,entity);
        entity.setCreateBy("周思远");
        entity.setCreateTime(new Date());
        thingRecordRepository.save(entity);
        return "success";
    }

    @Override
    public List<ThingRecordForm> queryAll() {
        Iterable<ThingRecordEntity> thingRecordEntities = thingRecordRepository.findAll();
        List<ThingRecordForm> thingRecordForms = new CopyOnWriteArrayList<>();
        for (ThingRecordEntity entity:thingRecordEntities) {
            ThingRecordForm form = new ThingRecordForm();
            BeanUtils.copyProperties(entity,form);
//            form.setAcquisitionTime(new SimpleDateFormat("yyyy-MM-dd").format(entity.getAcquisitionTime()));
//            if(form.getAcquisitionTime().equals(now().toString())){
//                skillCardForms.add(form);
//            }
            thingRecordForms.add(form);
        }
        return thingRecordForms;
    }
}
