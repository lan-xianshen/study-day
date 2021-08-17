package com.lan;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

/**
 * @author jianglin.lan
 * @title: com.lan.MainApplication
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/5 15:33
 */
@SpringBootApplication
public class MainApplication {
    public static void main (String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run (MainApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames ();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println (beanDefinitionName);

        }

        HashMap hashMap = new HashMap ();
        hashMap.put ("", "");
    }
}
