package com.lan.future.threadCir;

/**
 * @author lan
 * @create 2021-08-15 19:22
 */
public class MainThread {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new DeadThread(lockA, lockB) {

        }, "lockA").start();
        new Thread(new DeadThread(lockB, lockA) {

        }, "lockB").start();
    }
}
