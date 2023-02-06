package com.example.aop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author viper
 * @Date 2023/2/6 下午 01:01
 * @Version 1.0
 */
@Aspect
@Component
public class AnnotationAspect {
    
    /**
     * 定義切入點 新增
     */
    @Pointcut(value = "@annotation(com.example.aop.annotation.Add)")
    public void pointCutA() {
    }
    
    /**
     * 定義切入點 修改
     */
    @Pointcut(value = "@annotation(com.example.aop.annotation.Update)")
    public void pointCutB() {
    }
    
    /**
     * 定義切入點 刪除
     */
    @Pointcut(value = "@annotation(com.example.aop.annotation.Delete)")
    public void pointCutC() {
    }
    
    
    @Before("pointCutC()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
    }
    
    @After("pointCutA()")
    public void after(JoinPoint joinPoint) throws Exception {
        System.out.println("after");
    }
    
    @Around("pointCutB()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }
    
    @AfterThrowing(value = "pointCutA() || pointCutB() || pointCutC()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Exception error) {
        System.out.println("AfterThrowing=====>" + error);
    }
}
