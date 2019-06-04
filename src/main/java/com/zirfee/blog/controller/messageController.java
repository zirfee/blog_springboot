package com.zirfee.blog.controller;

import com.zirfee.blog.entity.message;
import com.zirfee.blog.service.messageService;
import com.zirfee.blog.service.visitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Map;

@RestController
public class messageController {
     @Autowired
    private messageService messageService;
     @Autowired
     private visitorService visitorService;

     @PostMapping("/message/sendMessage")
    public Object addMessage( @RequestBody Map<String,String> messageJson){
         message m = new message();
         m.setMessageContent(messageJson.get("content"));
         m.setMessageTime(new Timestamp(System.currentTimeMillis()));
         m.setVisitor(visitorService.getVisitorById(Long.valueOf(messageJson.get("visitorId"))));
         messageService.addMessage(m);
         return "success";
     }
     @GetMapping("/message/getMessages")
    public Object getAllMessages(){
         return messageService.getAllMessages();
     }
}
