package com.lan.test;

import com.lan.bean.Person;
import com.lan.config.MainConfig;
import com.lan.config.MainConfigTwo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author jianglin.lan
 * @title: IOCTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1813:53
 */
public class IOCTest {

    AnnotationConfigApplicationContext contextTwo =
            new AnnotationConfigApplicationContext (MainConfigTwo.class);


    private void printBeans (AnnotationConfigApplicationContext context) {
        String[] names = context.getBeanDefinitionNames ();
        for (String name : names) {
            System.out.println (name);
        }
    }

    @Test
    public void test01 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfig.class);
        printBeans (context);
    }

    @Test
    public void test02 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfigTwo.class);
        printBeans (context);
        Object person = context.getBean ("person");
        Object person02 = context.getBean ("person");
        System.out.println (person == person02);
    }

    @Test
    public void test03 () {
        String[] names = contextTwo.getBeanNamesForType (Person.class);
        for (String name : names) {
            System.out.println (name);
        }
        Map<String, Person> beansOfType = contextTwo.getBeansOfType (Person.class);
        System.out.println (beansOfType);
    }


    @Test
    public void testImport () {
        printBeans (contextTwo);
    }


}
