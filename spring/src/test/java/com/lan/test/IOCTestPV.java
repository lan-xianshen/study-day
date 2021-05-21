package com.lan.test;

import com.lan.bean.Person;
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
public class IOCTestPV {

    /*public static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext (MainConfigPropertyValue.class);*/

    @Test
    public void test01 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfigPropertyValue.class);
        printBeans (context);
        System.out.println ("++++==============");
        Person person = (Person) context.getBean ("person");
        System.out.println (person);
        context.close ();
    }

    private void printBeans (AnnotationConfigApplicationContext context) {
        String[] names = context.getBeanDefinitionNames ();
        for (String name : names) {
            System.out.println (name);
        }
    }
}
