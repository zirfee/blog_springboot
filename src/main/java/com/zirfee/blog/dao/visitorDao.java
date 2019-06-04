package com.zirfee.blog.dao;

import com.zirfee.blog.entity.visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface visitorDao extends JpaRepository<visitor,Long> {
}
