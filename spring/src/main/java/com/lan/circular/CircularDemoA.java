package com.lan.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: CircularDemoA
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/14 13:42
 */
@Component
public class CircularDemoA {
    public CircularDemoA(){
        System.out.println ("CircularDemoA created...");
    }

    @Autowired
    private CircularDemoB circularDemoB;

    public void demoA () {
        System.out.println ("demoA...");
    }
}
