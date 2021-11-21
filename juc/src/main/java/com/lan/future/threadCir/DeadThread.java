package com.lan.future.threadCir;

import java.util.concurrent.TimeUnit;

/**
 * @author lan
 * @create 2021-08-15 19:17
 */
public class DeadThread implements Runnable{
    private String lockA;
    private String lockB;

    public DeadThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread ().getName ()+"线程获得"+lockA);
            try {
                TimeUnit.SECONDS.sleep (2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread ().getName ()+"线程获得"+lockB);

            }
        }
    }
}

