package com.edu.rp.concurrent.conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @功能描述：
 */
public class ConditionAwait extends Thread{

    private Lock lock;
    private Condition condition;

    public ConditionAwait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        try {
            /* 获取锁 */
            lock.lock();

            try {
                System.out.println("begin:" + "ConditionAwait");
                /* 阻塞线程 */
                condition.await();
                System.out.println("end:" + "ConditionAwait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            /* 释放锁 */
            lock.unlock();
        }
    }
}
