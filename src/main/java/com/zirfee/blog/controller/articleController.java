package com.zirfee.blog.controller;

import com.zirfee.blog.entity.article;
import com.zirfee.blog.service.articleService;
import com.zirfee.blog.service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class articleController {
    @Autowired
    private articleService articleService;
    @Autowired
    private tagService tagService;

    @PostMapping("/article/addArticle")
    public Object addArticle(@RequestBody Map<String,Object> jsonStr){
        article article = new article();
        article.setArticleTitle((String)jsonStr.get("articleTitle"));
        article.setArticleDescribe((String)jsonStr.get("articleDescribe"));
        article.setArticleContent((String)jsonStr.get("articleContent"));
        article.setTags(tagService.getTagsByTitle((List<String>)jsonStr.get("articleTags")));
        articleService.addArticle(article);
        return "success";
    }
    @GetMapping("/article/getAllArticlesProfile")
    public Object getAllArticlesProfile(){
        return articleService.getAllArticlesProfile();
    }

    @GetMapping("/article/getArticle/{articleId}")
    public Object getOneArticle(@PathVariable("articleId") Long articleId){
        return articleService.getArticle(articleId);
    }
    @GetMapping("/article/getRecommend")
    public Object getRecommend(){
        return articleService.getRecommend();
    }
    @GetMapping("/article/getArticleByTag/{tagTitle}")
    public Object getArticleByTag(@PathVariable("tagTitle") String tagTitle){
        return articleService.getByTagTitle(tagTitle);
    }
    @GetMapping("/article/getArticlesTime")
    public Object getArticlesTime(){
         return articleService.getMonth();
    }
    @GetMapping("/article/getArticleByTime/{time}")
    public Object getArticleByTime(@PathVariable("time") String time){
            return articleService.getArticleByTime("2019-06");
    }
}

