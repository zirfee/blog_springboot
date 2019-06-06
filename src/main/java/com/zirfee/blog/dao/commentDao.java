package com.zirfee.blog.dao;

import com.zirfee.blog.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentDao extends JpaRepository<comment,Long> {
    @Query(value = "select new comment(c.commentContent,c.commentTime,v.nickName) from comment c join c.visitor v join c.article a where a.articleId=:articleId order by c.commentTime desc ")
    List<comment> getCommentsByArticleId(@Param("articleId") Long articleId);
}
