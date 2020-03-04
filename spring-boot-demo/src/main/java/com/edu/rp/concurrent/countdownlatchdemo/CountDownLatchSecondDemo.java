package com.edu.rp.concurrent.countdownlatchdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @功能描述：
 * @author
 */
public class CountDownLatchSecondDemo extends Thread{
    private static CountDownLatch count = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchSecondDemo().start();
        }

        count.countDown();
    }

    @Override
    public void run() {
        try {
            /* count等于0时，await阻塞的线程才会释放，让1000个线程去阻塞1000个线程 */
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO ，真正去处理逻辑的，await阻塞的线程唤醒后，同时处理，模拟并发
        System.out.println("Thread-name:" + Thread.currentThread().getName());
    }
}
