package com.siyuan.base.biz;

import com.siyuan.base.dao.entity.Clothes;
import org.springframework.data.repository.CrudRepository;

public interface ClothesRepository extends CrudRepository<Clothes, Integer> {
}
