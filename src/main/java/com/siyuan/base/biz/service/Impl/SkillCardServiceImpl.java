package com.siyuan.base.biz.service.Impl;

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.dao.repository.SkillCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillCardServiceImpl implements SkillCardService {
    @Autowired
    private SkillCardRepository skillCardRepository;

    @Override
    public String saveSkillInfo() {
        System.out.println(skillCardRepository.count());
        return null;
    }
}
