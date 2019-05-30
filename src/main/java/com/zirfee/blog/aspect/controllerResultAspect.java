package com.zirfee.blog.aspect;


import com.zirfee.blog.utils.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class controllerResultAspect {
      @Around("execution(* com.zirfee.blog.controller.*.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable{
         Object res =  point.proceed();
             return ResultUtil.success(res);
    }
}
