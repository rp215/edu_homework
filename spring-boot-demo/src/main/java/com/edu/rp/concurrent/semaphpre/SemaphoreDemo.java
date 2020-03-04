package com.edu.rp.concurrent.semaphpre;

import java.util.concurrent.Semaphore;

/**
 * @功能描述：实现限流，拿到令牌去执行
 */
public class SemaphoreDemo {
    static class Car extends Thread{
        private Semaphore semaphore;
        private int num;

        public Car(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                /* 获取令牌 */
                semaphore.acquire();
                System.out.println("第" + num + "开进车位");

                Thread.sleep(5000);
                /* 释放令牌 */
                semaphore.release();
                System.out.println("第" + num + "开走~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /* 自定义5个令牌 */
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Thread(new Car(semaphore, i)).start();
        }

    }
}
