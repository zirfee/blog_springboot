package com.zirfee.blog.dao;

import com.zirfee.blog.entity.tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tagDao extends JpaRepository<tag,Integer> {
    tag findByTagTitle(String s);
}
