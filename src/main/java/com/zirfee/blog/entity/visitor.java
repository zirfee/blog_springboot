package com.zirfee.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "visitor")
public class visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitorId;
    private String nickName;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "visitor")
   /* @JoinColumn(name = "visitorId")*/
    private Set<message> messages;
    @OneToMany(mappedBy = "visitor")
    @JsonIgnore
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<message> getMessages() {
        return messages;
    }

    public void setMessages(Set<message> messages) {
        this.messages = messages;
    }

    public Set<comment> getComments() {
        return comments;
    }

    public void setComments(Set<comment> comments) {
        this.comments = comments;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
