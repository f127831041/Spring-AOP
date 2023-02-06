package com.example.aop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ControllerAspect {
    /**
     * 定義切入點
     */
    @Pointcut(value = "execution(* com.example.aop.controller.*.*(..))")
    public void pointCut() {
    }
    
    /**
     * 切入點前執行，根據@annotation判斷是否有該功能權限。
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.err.println("method ====> " + method.getName());
    }
}
