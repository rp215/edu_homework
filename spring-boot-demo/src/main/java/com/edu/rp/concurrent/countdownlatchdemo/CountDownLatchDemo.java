package com.edu.rp.concurrent.countdownlatchdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @功能描述：
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch count = new CountDownLatch(3);

        new Thread(()->{
            System.out.println("Thread-01");
            count.countDown();
        }).start();

        new Thread(()->{
            System.out.println("Thread-02");
            count.countDown();
        }).start();

        new Thread(()->{
            System.out.println("Thread-03");
            count.countDown();
        }).start();

        count.await();

        System.out.println("main");
    }
}
