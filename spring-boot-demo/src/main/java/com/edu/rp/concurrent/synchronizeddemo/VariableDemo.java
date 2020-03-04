package com.edu.rp.concurrent.synchronizeddemo;

/**
 * @功能描述：
 */
public class VariableDemo {

    private  static int count = 0;

    private static void incr() {
        synchronized (VariableDemo.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            new Thread(()->VariableDemo.incr()).start();
        }
        Thread.sleep(3000);
        System.out.println("计算结果：" + count);
    }
}
