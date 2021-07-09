package com.lan.test;

import com.lan.config.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jianglin.lan
 * @title: IOCTestExt
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/9 17:02
 */
public class IOCTestExt {
    @Test
    public void test02 () {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext (ExtConfig.class);
        context.close ();
    }
}
