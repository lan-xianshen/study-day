package com.lan.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author jianglin.lan
 * @title: MyApplicationListener
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/12 9:48
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    //当容器中发布此事件以后，方法触发
    @Override
    public void onApplicationEvent (ApplicationEvent event) {
        System.out.println ("收到的事件：" + event);
    }
}
