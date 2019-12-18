package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.biz.util.NumberUtil;
import com.siyuan.base.biz.util.TimeUtil;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.siyuan.base.domain.Enum.CompanyBis.*;

@Service
public class ThingRecordServiceImpl implements ThingRecordService {

    @Autowired
    private ThingRecordRepository thingRecordRepository;

    @Override
    public List<ThingRecordForm> getThingRecordByStatus(int thingStatus) {
        List<ThingRecordEntity> recordEntities = thingRecordRepository.findByStatus(thingStatus);
        List<ThingRecordForm> result = new CopyOnWriteArrayList<>();
        for (int i = 0; i < recordEntities.size(); i++) {
            ThingRecordForm form = new ThingRecordForm();
            BeanUtils.copyProperties(recordEntities.get(i), form);
            form.setCreateTime(TimeUtil.format(recordEntities.get(i).getCreateTime()));
            result.add(form);
        }
        return result;
    }

    @Override
    @Transactional
    public WebResponse save(ThingRecordForm form) {
        ThingRecordEntity addEntity = new ThingRecordEntity();
        BeanUtils.copyProperties(form, addEntity);
        addEntity.setId(new Date().getTime());
        addEntity.setCreateBy("周思远");
        addEntity.setCreateTime(new Date());
        addEntity.setThingStatus(THING_INIT.getStatus());
        addEntity.setRelationId(form.getId());
        thingRecordRepository.save(addEntity);
        //Logic 若为挂起事件的新增则需要修改父级事件的相关信息
        if (0 != form.getId()) {
            ThingRecordEntity updateEntity = new ThingRecordEntity();
            updateEntity.setId(form.getId());
            updateEntity.setThingStatus(THING_HANGUP.getStatus());
            thingRecordRepository.updateById(updateEntity);
        }
        return new WebResponse("success", "0000");
    }

    @Override
    @Transactional
    public WebResponse dealRecordInfo(ThingRecordForm form) {
        //Logic 修改当前任务信息
        ThingRecordEntity entity = new ThingRecordEntity();
        BeanUtils.copyProperties(form, entity);
        entity.setThingStatus(THING_DEAL.getStatus());
        setUpdateInfo(entity,form.getCreateTime());
        thingRecordRepository.updateById(entity);
        //Logic 修改关联父级任务信息
        if(form.getRelationId() != 0){
            ThingRecordEntity entityFather = thingRecordRepository.findById(form.getRelationId());
            entityFather.setThingStatus(THING_INIT.getStatus());
            thingRecordRepository.updateById(entityFather);
        }
        return new WebResponse("success", "0000");
    }

    private ThingRecordEntity setUpdateInfo(ThingRecordEntity entity,String cts){
        //Logic 事件花费时间点数的计算
        Date createTime = TimeUtil.turnToDate(cts);
        Double gapHour = TimeUtil.calculatetimeGapHour(createTime,new Date());
        entity.setSpendTime(Double.valueOf(NumberUtil.format(gapHour,1)));
        entity.setUpdateBy("周思远");
        entity.setUpdateTime(new Date());
        return entity;
    }

}