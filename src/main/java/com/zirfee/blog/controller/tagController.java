package com.zirfee.blog.controller;

import com.zirfee.blog.entity.tag;
import com.zirfee.blog.service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class tagController {
    @Autowired
    private tagService tagService;

    @GetMapping("/tag/getAllTags")
    public Object getAllTags(){
        return tagService.getAllTags();
    }
}
