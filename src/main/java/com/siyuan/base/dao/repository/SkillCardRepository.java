package com.siyuan.base.dao.repository;

import com.siyuan.base.dao.entity.SkillCardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillCardRepository extends CrudRepository<SkillCardEntity, Integer>{

    /**
     * 根据书籍主键查询书籍详细信息
     * @return 书籍详细信息
     */
    @Query(value = "select s.skill_type,s.skill_describe,s.skill_points,s.acquisition_time FROM skill_card s where to_days(acquisition_time) = to_days(now())", nativeQuery = true)
    List<SkillCardEntity> getSkillCardOneByTime();
}
