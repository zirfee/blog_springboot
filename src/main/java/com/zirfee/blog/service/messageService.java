package com.zirfee.blog.service;

import com.zirfee.blog.dao.messageDao;
import com.zirfee.blog.entity.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class messageService {
    @Autowired
    private messageDao messageDao;

     public String addMessage(message message){
         messageDao.save(message);
         return "success";
     }
     public List<message> getAllMessages(){
       return   messageDao.getAllMessages();
     }
}
