package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.dao.entity.SkillCardEntity;
import com.siyuan.base.dao.repository.SkillCardRepository;
import com.siyuan.base.web.form.SkillCardForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.time.LocalDate.now;

@Service
public class SkillCardServiceImpl implements SkillCardService {
    @Autowired
    private SkillCardRepository skillCardRepository;

    @Override
    public List<SkillCardForm> queryCurrentDayInfo() {
        Iterable<SkillCardEntity> skillCardEntities = skillCardRepository.findAll();
        List<SkillCardForm> skillCardForms = new CopyOnWriteArrayList<>();
        for (SkillCardEntity entity:skillCardEntities) {
            SkillCardForm form = new SkillCardForm();
            BeanUtils.copyProperties(entity,form);
            form.setAcquisitionTime(new SimpleDateFormat("yyyy-MM-dd").format(entity.getAcquisitionTime()));
            if(form.getAcquisitionTime().equals(now().toString())){
                skillCardForms.add(form);
            }
        }
        return skillCardForms;
    }

    @Override
    public String saveSkillInfo(SkillCardForm form) {
        SkillCardEntity entity = new SkillCardEntity();
        BeanUtils.copyProperties(form,entity);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            entity.setAcquisitionTime(sdf2.parse(form.getAcquisitionTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        entity.setCreateBy("周思远");
        entity.setCreateDate(new Date());
        entity.setUpdateBy("周思远");
        entity.setUpdateDate(new Date());
        System.out.println(skillCardRepository.save(entity)+"");
        return skillCardRepository.save(entity)+"";
    }

}
