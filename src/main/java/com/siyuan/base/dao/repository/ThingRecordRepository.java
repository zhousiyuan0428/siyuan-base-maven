package com.siyuan.base.dao.repository;

import com.siyuan.base.dao.entity.ThingRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ThingRecordRepository extends CrudRepository<ThingRecordEntity,Integer> {
    /**
     * 根据主键查询最新的问题
     * @return 书籍详细信息
     */
    @Query(value = "select * FROM thing_record ORDER BY id DESC LIMIT 0,1", nativeQuery = true)
    ThingRecordEntity getOneQuestion();
}
