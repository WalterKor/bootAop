package com.example.bootaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParmeterAop {

    @Pointcut("execution(* com.example.bootaop.controller..*.*(..))")
    private void cut(){}


    @Before("cut()")
    public  void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();


        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("returnObj");
        System.out.println(returnObj);
    }



}
