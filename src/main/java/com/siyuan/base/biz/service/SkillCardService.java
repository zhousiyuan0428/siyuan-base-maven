package com.siyuan.base.biz.service;

import com.siyuan.base.dao.entity.SkillCardEntity;

public interface SkillCardService {
    String saveSkillInfo();
    Iterable<SkillCardEntity> queryAll();
}
