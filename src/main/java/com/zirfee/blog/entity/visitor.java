package com.zirfee.blog.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "visitor")
public class visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitorId;
    private String nickName;
    private String email;
    @OneToMany(mappedBy = "visitor")
   /* @JoinColumn(name = "visitorId")*/
    private Set<message> messages;
    @OneToMany(mappedBy = "visitor")
    /*@JoinColumn(name = "visitorId")*/
    private Set<comment> comments;

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<message> getLeaveMessages() {
        return messages;
    }

    public void setLeaveMessages(Set<message> leaveMessages) {
        this.messages = leaveMessages;
    }

    public Set<comment> getComments() {
        return comments;
    }

    public void setComments(Set<comment> comments) {
        this.comments = comments;
    }
}
