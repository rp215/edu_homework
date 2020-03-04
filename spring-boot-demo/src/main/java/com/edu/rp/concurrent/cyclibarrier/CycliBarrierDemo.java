package com.edu.rp.concurrent.cyclibarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @功能描述：栅栏
 */
public class CycliBarrierDemo extends Thread{

    /* 可以使得一组线程到达一个同步点之前阻塞，直到最后一个线程到达屏障时，屏障才会开门 */

    private CyclicBarrier cyclicBarrier ;
    private String path;

    public CycliBarrierDemo(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            System.out.println("导入：" + path + "的数据");
            // TODO，真正去处理的业务逻辑

            /* 类似condition.await() */
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
