package com.siyuan.base.dao.repository;

import com.siyuan.base.dao.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
}
