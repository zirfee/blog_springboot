package com.zirfee.blog.service;

import com.zirfee.blog.dao.visitorDao;
import com.zirfee.blog.entity.visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class visitorService {
    @Autowired
    private visitorDao visitorDao;

    public visitor getVisitorById(Long id){
       return visitorDao.findById(id).get();
    }
    public String addVisitor(visitor visitor){
        visitorDao.save(visitor);
        return "success";
    }
}
