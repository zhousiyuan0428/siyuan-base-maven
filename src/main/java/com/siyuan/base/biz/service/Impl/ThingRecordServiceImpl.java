package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.biz.util.NumberUtil;
import com.siyuan.base.biz.util.TimeUtil;
import com.siyuan.base.dao.entity.SkillCardEntity;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import com.siyuan.base.domain.model.WebResponse;
import com.siyuan.base.web.form.ThingRecordForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.siyuan.base.domain.Enum.CompanyBis.THING_DEAL;
import static com.siyuan.base.domain.Enum.CompanyBis.THING_HANGUP;
import static com.siyuan.base.domain.Enum.CompanyBis.THING_INIT;

@Service
public class ThingRecordServiceImpl implements ThingRecordService {

    @Autowired
    private ThingRecordRepository thingRecordRepository;

    @Override
    @Transactional
    public WebResponse save(ThingRecordForm form) {
        ThingRecordEntity addEntity = new ThingRecordEntity();
        BeanUtils.copyProperties(form, addEntity);
        addEntity.setId(new Date().getTime());
        addEntity.setCreateBy("周思远");
        addEntity.setCreateTime(new Date());
        addEntity.setThingStatus(THING_INIT.getStatus());
        thingRecordRepository.save(addEntity);
        //Logic 挂起事件的新增需要修改父级事件的状态
        if (0 != form.getId()) {
            ThingRecordEntity updateEntity = new ThingRecordEntity();
            updateEntity.setId(form.getId());
            updateEntity.setThingStatus(THING_HANGUP.getStatus());
            thingRecordRepository.updateById(updateEntity);
        }
        return new WebResponse("success", "0000");
    }

    @Override
    public List<ThingRecordForm> getThingRecordByStatus(int thingStatus) {
        List<ThingRecordEntity> recordEntities = thingRecordRepository.findByStatus(thingStatus);
        List<ThingRecordForm> result = new CopyOnWriteArrayList<>();
        for (int i = 0; i < recordEntities.size(); i++) {
            ThingRecordForm form = new ThingRecordForm();
            BeanUtils.copyProperties(recordEntities.get(i), form);
            result.add(form);
        }
        return result;
    }

    @Override
    @Transactional
    public WebResponse update(ThingRecordForm form) {
        ThingRecordEntity entity = new ThingRecordEntity();
        BeanUtils.copyProperties(form, entity);
        entity.setId(form.getId());
        entity.setSolutionDescribe(form.getSolutionDescribe());
        entity.setThingStatus(THING_DEAL.getStatus());
        //Logic 事件花费时间点数的计算
        Date createTime = thingRecordRepository.findById(form.getId()).getCreateTime();
        Double gapHour = TimeUtil.calculatetimeGapHour(createTime,new Date());
        entity.setSpendTime(Double.valueOf(NumberUtil.format(gapHour,2)));
        entity.setUpdateBy("周思远");
        entity.setUpdateTime(new Date());
        thingRecordRepository.updateById(entity);
        return new WebResponse("success", "0000");
    }

}