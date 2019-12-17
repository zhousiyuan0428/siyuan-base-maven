package com.siyuan.base.dao.repository;

import com.siyuan.base.dao.entity.ThingRecordEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThingRecordRepository extends CrudRepository<ThingRecordEntity,Integer> {

    /**
     * 根据任务状态查询任务信息
     * @param thingStatus
     * @return List<ThingRecordEntity>
     */
    @Query(value = "SELECT * FROM thing_record r WHERE r.thing_status = :thingStatus", nativeQuery = true)
    List<ThingRecordEntity> findByStatus(@Param("thingStatus") int thingStatus);

    /**
     * 根据任务id查询任务信息
     * @param id
     * @return List<ThingRecordEntity>
     */
    @Query(value = "SELECT * FROM thing_record r WHERE r.id = :id", nativeQuery = true)
    ThingRecordEntity findById(@Param("id") long id);

    /**
     * 根据任务id进行任务修改
     * @param tre
     * @return int
     */
    @Modifying
    @Query(value = "update ThingRecordEntity t set t.thingStatus = :#{#tre.thingStatus},"+
            "t.solutionDescribe = :#{#tre.solutionDescribe},t.spendTime = :#{#tre.spendTime},"+
            "t.updateBy = :#{#tre.updateBy},t.updateTime = :#{#tre.updateTime} where t.id = :#{#tre.id}")
    int updateById(@Param("tre") ThingRecordEntity tre);
}
