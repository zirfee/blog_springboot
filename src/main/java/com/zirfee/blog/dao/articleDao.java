package com.zirfee.blog.dao;

import com.zirfee.blog.entity.article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface articleDao extends JpaRepository<article,Long> {

    /* @Query("select a.id,a.articleTitle,a.articleDescribe,a.articleTime,t.tagTitle,a.likeTimes,a.commentTimes,a.readTimes from article a join a.tags t")
     List<Object[]> getProfile();*/
    @Query(value = "select new com.zirfee.blog.entity.article(a.articleId,a.articleTitle, a.articleDescribe,a.articleTime, a.readTimes,a.commentTimes, a.likeTimes)  from article a")
    List<article> getProfile();

    @Query(value = "select new com.zirfee.blog.entity.article(a.articleId,a.articleTitle)  from article a")
    List<article> getRecommend();

    @Query(value = "select new com.zirfee.blog.entity.article(a.articleId,a.articleTitle, a.articleDescribe,a.articleTime, a.readTimes,a.commentTimes, a.likeTimes)  from article a join a.tags b where b.tagTitle = :tagTitle")
    List<article> getByTagTitle(@Param("tagTitle") String tagTitle);

    @Query(value = "select DATE_FORMAT(article_time,'%Y%m') months,count(article_id) count from article group by months",nativeQuery = true)
    List<Object[]> getMonths();

   /* List<article> findAllByArticleTimeLike(String time);*/
    @Query(value = "select a.article_id,a.article_title,a.article_describe,a.article_time,a.read_times,a.comment_times,a.like_times from article a where a.article_time like ?1%",nativeQuery = true)
     List<Object[]> getArticleByTime(String time);
}