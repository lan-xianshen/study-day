package com.lan.singloton;

import singleton.LazySimpleSingleTon;

/**
 * @author lan
 * @create 2021-08-18 12:03
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleTon lazy = LazySimpleSingleTon.getInstance();
        System.out.println(Thread.currentThread().getName()+"=="+lazy);
    }
}
