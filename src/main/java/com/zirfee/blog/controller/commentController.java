package com.zirfee.blog.controller;

import com.zirfee.blog.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class commentController {
    @Autowired
    private com.zirfee.blog.service.commentService commentService;

    @GetMapping("/comment/getArticleComments/{articleId}")
    public Object getArticleComments(@PathVariable("articleId") Long articleId){
        return commentService.getCommentsByArticleId(articleId);
    }
    @PostMapping("/comment/addComment")
    public Object addCommentByArticleIdAndVisitorId(@RequestBody Map<String,String> content, @RequestParam("articleId") Long articleId, @RequestParam("visitorId") Long visitorId){
          return commentService.addCommentByArticleIdAndVisitorId(content.get("content"),articleId,visitorId);
    }
}
