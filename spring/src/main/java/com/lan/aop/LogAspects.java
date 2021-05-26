package com.lan.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: LogAspects
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/2516:29
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.lan.aop.MathCacultaor.div(int,int))")
    public void pointCut () {
    }


    @Before("pointCut()")
    public void logStart () {
        System.out.println ("��������====�����б�{}");
    }

    @After("pointCut()")
    public void logEnd () {
        System.out.println ("��������");
    }

    @AfterReturning("pointCut()")
    public void logReturn () {
        System.out.println ("������������===����ǣ�{}");
    }

    @AfterThrowing("pointCut()")
    public void logException () {
        System.out.println ("�����쳣===�쳣��Ϣ�ǣ�{}");
    }
}
