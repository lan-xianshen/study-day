package com.lan.test;

import com.lan.config.MainConfigLife;
import com.lan.config.MainConfigTX;
import com.lan.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jianglin.lan
 * @title: IOCTestTX
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/1 15:35
 */
public class IOCTestTX {

    @Test
    public void test01 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (MainConfigTX.class);
        UserService bean = context.getBean (UserService.class);
        System.out.println ("insert...before");
        bean.insert ();
        System.out.println ("insert...after");
        context.close ();

    }
}
