package com.edu.rp.springbootdemo;

/**
 * @功能描述：
 * @author
 */
public class DeadLockDemo implements Runnable{
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    private boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(false);
        new Thread(deadLockDemo1).start();
        new Thread(deadLockDemo2).start();

    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (object1) {
                    System.out.println("object1获取锁");
                    synchronized (object2) {
                        System.out.println("object2获取锁");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (object2) {
                    System.out.println("object2获取锁");
                    synchronized (object1) {
                        System.out.println("object1获取锁");
                    }
                }
            }
        }
    }
}
