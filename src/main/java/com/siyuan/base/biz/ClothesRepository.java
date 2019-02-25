package com.siyuan.base.biz;

import com.siyuan.base.entity.Clothes;
import org.springframework.data.repository.CrudRepository;

public interface ClothesRepository extends CrudRepository<Clothes, Integer> {
}
