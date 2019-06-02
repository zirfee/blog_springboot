package com.zirfee.blog.service;

import com.zirfee.blog.dao.tagDao;
import com.zirfee.blog.entity.tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class tagService {
    @Autowired
    private tagDao  tagDao;

    public Set<tag>  getTagsByTitle(List<String> lst){
        Set<tag> set = new HashSet<>();
        for(String s : lst){
            set.add(tagDao.findByTagTitle(s));
        }
        return set;
    }
    public List<tag> getAllTags(){
        return tagDao.findAll();
    }


}
