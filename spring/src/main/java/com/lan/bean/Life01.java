package com.lan.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: Life01
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/19 11:03
 */
//@Component
public class Life01 implements InitializingBean, DisposableBean {
    public Life01 () {
        System.out.println ("life01 constructor.....");
    }

    @Override
    public void destroy () throws Exception {
        System.out.println ("life01.......destroy");
    }

    @Override
    public void afterPropertiesSet () throws Exception {
        System.out.println ("life01........afterPropertiesSet");

    }
}
