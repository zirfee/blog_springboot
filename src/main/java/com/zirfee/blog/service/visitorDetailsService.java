package com.zirfee.blog.service;

import com.zirfee.blog.dao.visitorDao;
import com.zirfee.blog.entity.JwtVisitor;
import com.zirfee.blog.entity.visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class visitorDetailsService implements UserDetailsService {
    @Autowired
    private visitorDao visitorDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        visitor visitor = visitorDao.findByEmail(s);
        return new JwtVisitor(visitor);
    }
}
