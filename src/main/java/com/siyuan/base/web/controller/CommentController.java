package com.siyuan.base.web.controller;

import com.siyuan.base.dao.entity.Comment;
import com.siyuan.base.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/insert")
    @ResponseBody
    public String insertComment() {
        for (int i = 3; i < 20; i++) {
            Comment comment = new Comment();
            comment.setRealtimeId(1);
            comment.setUserName("用户"+i);
            comment.setHotNum(i);
            comment.setPublishData(new Date());
            commentRepository.save(comment);
        }
        return "Saved";
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        
    }
}
