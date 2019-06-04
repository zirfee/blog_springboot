package com.zirfee.blog.dao;

import com.zirfee.blog.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentDao extends JpaRepository<comment,Long> {
}
