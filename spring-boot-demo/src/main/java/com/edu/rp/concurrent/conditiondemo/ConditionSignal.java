package com.edu.rp.concurrent.conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @功能描述：
 */
public class ConditionSignal extends Thread{

    private Lock lock;
    private Condition condition;

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            /* 获取锁 */
            lock.lock();

            System.out.println("begin:" + "ConditionSignal");
            /* 唤醒调用await的线程 */
            condition.signal();
            System.out.println("end:" + "ConditionSignal");
        } finally {
            /* 释放锁 */
            lock.unlock();
        }
    }
}
