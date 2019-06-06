package com.zirfee.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity(name = "comment")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private String commentContent;
    private Timestamp commentTime;
    @ManyToOne
    @JoinColumn(name = "visitorId")
    private visitor visitor;
    @ManyToOne
    @JoinColumn(name = "articleId")
    private article article;
    @Transient
    private String visitorNickname;

    public comment() {
    }

    public comment(String commentContent, Object commentTime, String visitorNickname) {
        this.commentContent = commentContent;
        this.commentTime = (Timestamp) commentTime;
        this.visitorNickname = visitorNickname;
    }

    public String getVisitorNickname() {
        return visitorNickname;
    }

    public void setVisitorNickname(String visitorNickname) {
        this.visitorNickname = visitorNickname;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public com.zirfee.blog.entity.visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(com.zirfee.blog.entity.visitor visitor) {
        this.visitor = visitor;
    }

    public com.zirfee.blog.entity.article getArticle() {
        return article;
    }

    public void setArticle(com.zirfee.blog.entity.article article) {
        this.article = article;
    }
}
