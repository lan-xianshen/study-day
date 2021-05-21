package com.lan.test;

import com.lan.bean.Person;
import com.lan.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author jianglin.lan
 * @title: MainTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1410:20
 */
public class MainTest {
    public static void main (String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("/beans" +
                ".xml");
        Person bean = (Person) context.getBean ("person");
        System.out.println (bean);


        BigDecimal bigDecimal = new BigDecimal (Double.toString (-1));
        System.out.println (bigDecimal);

        AnnotationConfigApplicationContext contexAnnot =
                new AnnotationConfigApplicationContext (MainConfig.class);
        Person beanA = (Person) contexAnnot.getBean ("person");
        System.out.println (beanA);

    }
}
