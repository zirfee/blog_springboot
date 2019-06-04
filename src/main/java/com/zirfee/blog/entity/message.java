package com.zirfee.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "message")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private Timestamp messageTime;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private String messageContent;
    @ManyToOne
    @JoinColumn(name = "visitorId")
    @JsonIgnore
    private visitor visitor;

    @Transient
    private String visitorName;

     public message(){

    }

    public message(Object messageTime, String messageContent, String visitorName) {
        this.messageTime = (Timestamp) messageTime;
        this.messageContent = messageContent;
        this.visitorName = visitorName;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public com.zirfee.blog.entity.visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(com.zirfee.blog.entity.visitor visitor) {
        this.visitor = visitor;
    }
}
