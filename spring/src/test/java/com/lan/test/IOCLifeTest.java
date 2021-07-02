package com.lan.test;

import com.lan.config.MainConfigLife;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jianglin.lan
 * @title: IOCLifeTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1910:35
 */

public class IOCLifeTest {
    public static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext (MainConfigLife.class);

    @Test
    public void test01 () {
        System.out.println ("容器创建完成");
        String[] names = context.getBeanDefinitionNames ();
        for (String name : names
        ) {
            System.out.println (name);
        }
      context.close ();

    }

}
