package com.zirfee.blog.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "article")
public class article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column(length = 100,nullable = false)
    private String articleTitle;
    @Column(nullable = false)
    private String articleDescribe;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String articleContent;
    private Timestamp articleTime;
    private Long readTimes;
    private Long commentTimes;
    private Long likeTimes;
    @ManyToMany
    @JoinTable(name = "article_tag",inverseJoinColumns = @JoinColumn(name = "tag_id"),
            joinColumns = @JoinColumn(name = "article_id") )
    private Set<tag> tags=new HashSet<>();

    public article(){

    }

    public article(Long articleId,String articleTitle, String articleDescribe,Object articleTime, Long readTimes, Long commentTimes, Long likeTimes) {
        this.articleId=articleId;
        this.articleTitle = articleTitle;
        this.articleDescribe = articleDescribe;
        this.articleTime=(Timestamp) articleTime;
        this.readTimes = readTimes;
        this.commentTimes = commentTimes;
        this.likeTimes = likeTimes;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleDescribe() {
        return articleDescribe;
    }

    public void setArticleDescribe(String articleDescribe) {
        this.articleDescribe = articleDescribe;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    public Long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }

    public Long getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Long commentTimes) {
        this.commentTimes = commentTimes;
    }

    public Long getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(Long likeTimes) {
        this.likeTimes = likeTimes;
    }

    public Set<tag> getTags() {
        return tags;
    }

    public void setTags(Set<tag> tags) {
        this.tags = tags;
    }
}
