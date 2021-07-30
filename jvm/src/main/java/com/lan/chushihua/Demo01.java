package com.lan.chushihua;

/**
 * @author jianglin.lan
 * @title: Demo01
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/28 13:23
 */
public class Demo01 {
    static {
        //给变量赋值可以正常编译通过
        i = 0;

        //这句编译器会提示"非法向前引用" Illegal forward reference
        //System.out.print (i);

    }

    static int i = 1;
}
