package com.zirfee.blog.controller;

import com.zirfee.blog.entity.article;
import com.zirfee.blog.service.articleService;
import com.zirfee.blog.service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
}

