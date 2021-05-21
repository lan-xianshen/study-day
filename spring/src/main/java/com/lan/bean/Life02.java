package com.lan.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jianglin.lan
 * @title: Life02
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1911:15
 */
//@Component
public class Life02 {
    public Life02 () {
        System.out.println ("life02 constructor...........");
    }

    @PostConstruct
    public void init () {
        System.out.println ("life02............PostConstruct.");
    }

    @PreDestroy
    public void destroy () {
        System.out.println ("life02............PreDestroy.");
    }
}
