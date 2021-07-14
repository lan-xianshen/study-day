package com.lan.test;

import com.lan.circular.CircularDemoA;
import com.lan.circular.CircularDemoB;
import com.lan.config.CircularConfig;
import com.lan.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jianglin.lan
 * @title: IOCTestCir
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/14 13:49
 */

public class IOCTestCir {
    @Test
    public void test01 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (CircularConfig.class);
        CircularDemoA demoA = context.getBean (CircularDemoA.class);
        CircularDemoB demoB = context.getBean (CircularDemoB.class);
        System.out.println (demoA + "<=====>" + demoB);
        context.close ();
    }

}
