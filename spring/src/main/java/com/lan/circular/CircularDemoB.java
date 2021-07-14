package com.lan.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jianglin.lan
 * @title: CircularDemoB
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/14 13:43
 */
@Component
public class CircularDemoB {

    public CircularDemoB () {
        System.out.println ("CircularDemoB created...");
    }

    @Autowired
    private CircularDemoA circularDemoA;

    public void demoB () {
        System.out.println ("demoB...");
    }

}
