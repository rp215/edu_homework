package com.edu.rp.concurrent.threadtype;

import java.util.concurrent.TimeUnit;

/**
 * @功能描述：线程生命周期demo
 */
public class ThreadLifeCycleDemo {

    public static void main(String[] args) {

        /* WAITING状态，包括wait,join,park(与之对应的notify/notifyAll,unPark) */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (ThreadLifeCycleDemo.class) {
                        try {
                            ThreadLifeCycleDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "WAITING-Thread").start();


        /* TIMED_WAITING状态，包括sleep */
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "TIMED_WAITING-Thread").start();


        /* BLOCKED状态 */
        new Thread(new BlockedDemo(), "Thread->0").start();
        new Thread(new BlockedDemo(), "Thread->1").start();

    }

     static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
