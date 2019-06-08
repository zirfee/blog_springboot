package com.zirfee.blog.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class JwtVisitor implements UserDetails {
    private Long visitorId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtVisitor(){

    }
    public JwtVisitor(visitor visitor){
         this.visitorId=visitor.getVisitorId();
         this.username=visitor.getEmail();
         this.password=visitor.getPassword();
        authorities = Collections.singleton(new SimpleGrantedAuthority(visitor.getRole()));
    }

    public Long getVisitorId() {
        return visitorId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + visitorId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
