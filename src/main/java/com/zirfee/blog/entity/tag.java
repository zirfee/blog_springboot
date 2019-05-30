package com.zirfee.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tag")
public class tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    @Column(length = 20,nullable = false)
    private String tagTitle;
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<article> articles = new HashSet<>();

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public Set<article> getArticles() {
        return articles;
    }

    public void setArticles(Set<article> articles) {
        this.articles = articles;
    }
}
