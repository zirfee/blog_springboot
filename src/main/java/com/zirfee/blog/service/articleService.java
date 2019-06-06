package com.zirfee.blog.service;

import com.zirfee.blog.dao.articleDao;
import com.zirfee.blog.entity.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class articleService {
    @Autowired
    private articleDao articleDao;

    public List<article> getAllArticlesProfile(){
        return articleDao.getProfile();
    }
    public List<article> getRecommend(){
        return articleDao.getRecommend();
    }
     public List<article> getByTagTitle(String tagTitle){
        return articleDao.getByTagTitle(tagTitle);
     }

   public List<Object[]> getMonth(){
      return  articleDao.getMonths();
   }
   public List<Object> getArticleByTime(String time){
      /* Iterator it=articleDao.getArticleByTime(time).iterator();*/
      /* articleDao.getArticleByTime(time).stream().forEach(item->System.out.println(item[0]));*/
       List<Object> list = new ArrayList<>();
       List<Object[]> li=articleDao.getArticleByTime(time);
       for (Object[] ob:li){
           article a = new article();
            a.setArticleId(((BigInteger) ob[0]).longValue());
            a.setArticleTitle((String) ob[1]);
            a.setArticleDescribe((String) ob[2]);
            a.setArticleTime((Timestamp) ob[3]);
            a.setReadTimes(((BigInteger) ob[4]).longValue());
            a.setCommentTimes(((BigInteger) ob[5]).longValue());
            a.setLikeTimes(((BigInteger) ob[6]).longValue());
            list.add(a);
       }
        return list;
   }
    public List<article> getAllArticles(){
        return articleDao.findAll();
    }
    public article getArticleById(Long articleId){
        return articleDao.findById(articleId).get();
    }
    public void addArticle(article article){
        articleDao.save(article);
    }
    public void updateArticle(article article){
        articleDao.save(article);
    }
    public void deleteArticleById(Long articleId){
        articleDao.deleteById(articleId);
    }
}

