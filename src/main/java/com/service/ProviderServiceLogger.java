package com.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ProviderServiceLogger {
    @Pointcut("execution(* *.service.*.*(*))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        System.out.println("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
    }
    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public void afterReturning(JoinPoint jp, Object returnValue) {
        System.out.println("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                + " 方法。方法返回值：" + returnValue);
    }
}
