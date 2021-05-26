package com.lan.test;

import com.lan.bean.Person;
import com.lan.config.MainConfigProfile;
import com.lan.config.MainConfigPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jianglin.lan
 * @title: IOCTestPV
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1914:44
 */
public class IOCTestProfile {

    /*public static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext (MainConfigPropertyValue.class);*/

    @Test
    public void test01 () {
       /* 环境选择：
                1）、使用命令行参数更改环境：-Dspring.profiles.active=test
                2）、使用无参创建IOC new AnnotationConfigApplicationContext(),
                        设置需要激活的环境 context.getEnvironment ().setActiveProfiles ("dev","test");
                        注册主配置类
                        启动刷新容器
        */
       /*   AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfigProfile.class);*/
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext ();
        context.getEnvironment ().setActiveProfiles ("dev");
        context.register (MainConfigProfile.class);
        context.refresh ();

        printBeans (context);

        context.close ();
    }

    private void printBeans (AnnotationConfigApplicationContext context) {
        String[] names = context.getBeanDefinitionNames ();
        for (String name : names) {
            System.out.println (name);
        }
    }
}
