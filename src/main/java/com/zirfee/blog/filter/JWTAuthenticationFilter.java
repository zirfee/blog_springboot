package com.zirfee.blog.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zirfee.blog.entity.JwtVisitor;
import com.zirfee.blog.model.loginVisitor;
import com.zirfee.blog.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by echisan on 2018/6/23
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");  //登录路径
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息
        try {
            loginVisitor  loginVisitor = new ObjectMapper().readValue(request.getInputStream(), loginVisitor.class);
            rememberMe.set( loginVisitor.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginVisitor.getEmail(), loginVisitor.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JwtVisitor  JwtVisitor = ( JwtVisitor) authResult.getPrincipal();
        System.out.println("jwtUser:" +  JwtVisitor.toString());
        boolean isRemember = rememberMe.get() == 1;

        String role = "";
        Collection<? extends GrantedAuthority> authorities =  JwtVisitor.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        String token = JwtTokenUtils.createToken(JwtVisitor.getUsername(), role, isRemember);
//        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        response.setHeader("id",String.valueOf(JwtVisitor.getVisitorId()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("loginFail");
    }
}
