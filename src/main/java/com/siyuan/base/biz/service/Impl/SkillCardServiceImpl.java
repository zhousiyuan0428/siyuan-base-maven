package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.biz.util.CalculateUtil;
import com.siyuan.base.dao.entity.SkillCardEntity;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.SkillCardRepository;
import com.siyuan.base.web.form.SkillCardForm;
import com.siyuan.base.web.form.SkillEchartForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SkillCardServiceImpl implements SkillCardService {
    @Autowired
    private SkillCardRepository skillCardRepository;

    @Override
    public List<SkillCardForm> queryCurrentDayInfo() {
        Iterable<SkillCardEntity> skillCardEntities = skillCardRepository.getCurrentInfo();
        List<SkillCardForm> skillCardForms = new CopyOnWriteArrayList<>();
        for (SkillCardEntity entity:skillCardEntities) {
            SkillCardForm form = new SkillCardForm();
            form.setAcquisitionTime(CalculateUtil.format(entity.getAcquisitionTime()));
            BeanUtils.copyProperties(entity,form);
            skillCardForms.add(form);
        }
        return skillCardForms;
    }

    @Override
    public void saveSkillInfo(SkillCardEntity entity) {
        SkillCardEntity skillCardEntity = new SkillCardEntity();
        setAuthor(skillCardEntity);
        skillCardRepository.save(skillCardEntity);
        return;
    }

    @Override
    public List<SkillEchartForm> querySevenDayInfo() {
        String pastDay = CalculateUtil.getPastDate(6);
        List<SkillCardEntity> skillCardEntities =
                skillCardRepository.getGoalInfo(pastDay, CalculateUtil.format(new Date()));
        List<SkillEchartForm> skillEchartForms = new CopyOnWriteArrayList<>();
        //按天将技能分组
        List<String> sevenDays = CalculateUtil.getSevenDay(6,true);
        for (String day:sevenDays) {
            SkillEchartForm form = new SkillEchartForm();
            form.setName(day);
            List<SkillCardEntity> skillEntities = new CopyOnWriteArrayList<>();
            for (int j = 0; j < skillCardEntities.size(); j++) {
                if(day.equals(CalculateUtil.format2(skillCardEntities.get(j).getAcquisitionTime()))){
                    skillEntities.add(skillCardEntities.get(j));
                }
            }
            form.setSkillCardEntities(skillEntities);
            skillEchartForms.add(form);
        }
        return skillEchartForms;
    }

    private SkillCardEntity setAuthor(SkillCardEntity entity){
        entity.setAcquisitionTime(new Date());
        entity.setCreateBy("周思远");
        entity.setCreateDate(new Date());
        entity.setUpdateBy("周思远");
        entity.setUpdateDate(new Date());
        return entity;
    }

}
