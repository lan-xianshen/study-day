package com.lan.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: Life
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/19 10:31
 */
public class Life {
    public Life () {
        System.out.println ("Life construct.....");
    }
    public void init(){
        System.out.println ("life............init.");
    }
    public void destory(){
        System.out.println ("life............destory.");
    }


}
