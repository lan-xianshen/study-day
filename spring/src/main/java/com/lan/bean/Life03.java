package com.lan.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: Life03
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1914:28
 */
@Component
public class Life03 implements ApplicationContextAware {
    ApplicationContext applicationContext = null;

    public Life03 () {
        System.out.println ("Life03.........................constructor");
    }

    @Override
    public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
