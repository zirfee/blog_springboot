package com.zirfee.blog.service;

import com.zirfee.blog.dao.commentDao;
import com.zirfee.blog.entity.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class commentService {
    @Autowired
    private com.zirfee.blog.dao.commentDao commentDao;
    @Autowired
    private visitorService visitorService;
    @Autowired
    private articleService articleService;

    public List<comment> getCommentsByArticleId(Long articleId){
        return commentDao.getCommentsByArticleId(articleId);
    }

    public String addCommentByArticleIdAndVisitorId(String content,Long articleId,Long visitorId){
        comment comment = new comment();
         comment.setCommentContent(content);
         comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
         comment.setVisitor(visitorService.getVisitorById(visitorId));
         comment.setArticle(articleService.getArticleById(articleId));
         commentDao.save(comment);
        return "success";
    }
}
