package com.lan.chushihua;

import javafx.scene.Parent;

/**
 * @author jianglin.lan
 * @title: Demo02
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/28 13:26
 */
class Demo02{
    // Variable 'A' initializer '1' is redundant
    public static int A=1;

    static{
        A=2;
    }

    static class Sub extends Demo02 {
        public static int B=A;
    }
    public static void main(String[]args){
        System.out.println(Sub.B);
    }
}

