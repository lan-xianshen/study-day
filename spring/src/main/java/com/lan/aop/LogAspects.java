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
        System.out.println ("除法运行====参数列表：{}");
    }

    @After("pointCut()")
    public void logEnd () {
        System.out.println ("除法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn () {
        System.out.println ("除法正常返回===结果是：{}");
    }

    @AfterThrowing("pointCut()")
    public void logException () {
        System.out.println ("除法异常===异常信息是：{}");
    }
}
