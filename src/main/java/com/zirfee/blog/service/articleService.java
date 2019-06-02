package com.zirfee.blog.service;

import com.zirfee.blog.dao.articleDao;
import com.zirfee.blog.entity.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public List<article> getAllArticles(){
        return articleDao.findAll();
    }
    public article getArticle(Long articleId){
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

