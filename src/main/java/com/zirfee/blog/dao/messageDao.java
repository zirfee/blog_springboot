package com.zirfee.blog.dao;

import com.zirfee.blog.entity.message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface messageDao extends JpaRepository<message,Long> {
    @Query(value = "select new message(m.messageTime,m.messageContent,v.nickName) from message m join m.visitor v")
    List<message> getAllMessages();
}
