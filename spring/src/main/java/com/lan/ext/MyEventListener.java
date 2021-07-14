package com.lan.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author jianglin.lan
 * @title: MyEventListener
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/12 13:08
 */
@Service
public class MyEventListener {

    @EventListener(classes = {ApplicationEvent.class})
    public void listen (ApplicationEvent event) {
        System.out.println ("MyEventListener===:" + event);
    }
}
