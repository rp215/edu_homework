package com.edu.rp.concurrent.conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @功能描述：
 */
public class ConditionTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        /**
         * ConditionSignal线程若仙运行，则ConditionAwait调用await方法之后会一直阻塞
         */
        new Thread(new ConditionAwait(lock, condition)).start();
        new Thread(new ConditionSignal(lock, condition)).start();

        /**
         * 运营结果：
         * 第一种：ConditionSignal线程首先运行
         * begin:ConditionSignal
         * end:ConditionSignal
         * begin:ConditionAwait
         *
         * 第二种：ConditionAwait线程首先运行
         * begin:ConditionAwait
         * begin:ConditionSignal
         * end:ConditionSignal
         * end:ConditionAwait
         */
    }
}
