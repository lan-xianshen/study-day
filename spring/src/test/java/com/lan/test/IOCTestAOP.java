package com.lan.test;

import com.lan.aop.MathCacultaor;
import com.lan.bean.Person;
import com.lan.config.MainConfigOfAOP;
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
public class IOCTestAOP {

    @Test
    public void test01 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfigOfAOP.class);
        MathCacultaor bean = context.getBean (MathCacultaor.class);
        bean.div (10, 3);
        System.out.println ("++++==============");

        context.close ();
    }


}
