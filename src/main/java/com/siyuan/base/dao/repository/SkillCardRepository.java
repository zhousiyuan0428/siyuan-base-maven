package com.siyuan.base.dao.repository;

import com.siyuan.base.dao.entity.SkillCardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillCardRepository extends CrudRepository<SkillCardEntity, Integer>{
    /**
     * 获取今日得到的技能点数
     * @return List<SkillCardEntity>
     */
    @Query(value = "select * FROM skill_card s where to_days(acquisition_time) = to_days(now())", nativeQuery = true)
    List<SkillCardEntity> getCurrentInfo();

    /**
     * 获取时间短技能点数
     * @return List<SkillCardEntity>
     */
    @Query(value = "select * FROM skill_card s where s.create_date between :starDate and :endDate", nativeQuery = true)
    List<SkillCardEntity> getGoalInfo(@Param("starDate") String starDate,@Param("endDate") String endDate);

    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i);
    }
}
