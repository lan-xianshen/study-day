package com.lan.singloton;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import singleton.LazyCheckSingleton;
import singleton.LazySimpleSingleTon;

/**
 * @author lan
 * @create 2021-08-18 12:02
 */
public class LazySingleTonTest {
    public static void main(String[] args) {
     /*   for (int i = 0; i <3; i++) {
            new Thread(() -> {
                LazySimpleSingleTon simpleSingleTon = LazySimpleSingleTon.getInstance();

                System.out.println(Thread.currentThread().getName() + "=" + simpleSingleTon);

            }, String.valueOf(i)+"A").start();
        }*/
     for (int i = 0; i <3; i++) {
         new Thread (() -> {
             LazyCheckSingleton simpleSingleTon = LazyCheckSingleton.getInstance();
             System.out.println(Thread.currentThread().getName() + "=" + simpleSingleTon);
         }, String.valueOf(i)+"A").start ();
     }
        System.out.println("end");
    }

}
