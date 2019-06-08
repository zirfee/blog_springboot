package com.zirfee.blog.controller;

import com.zirfee.blog.entity.visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class visitorController {
    @Autowired
    private com.zirfee.blog.service.visitorService visitorService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/visitor/addVisitor")
    public Object addVisitor(@RequestBody Map<String,String> visitorJson){
        visitor v = new visitor();
         v.setNickName(visitorJson.get("nickName"));
         v.setPassword(bCryptPasswordEncoder.encode(visitorJson.get("password")));
         v.setEmail(visitorJson.get("email"));
         v.setRole("ROLE_VISITOR");
         visitorService.addVisitor(v);
        return "success";
    }
    @GetMapping("/visitor/getVisitorById/{id}")
    public Object getVisitorById(@PathVariable("id") String id){
         return visitorService.getVisitorById(Long.valueOf(id));
    }
}
