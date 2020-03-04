package com.edu.rp.concurrent.cyclibarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @功能描述：
 */
public class CycliBarrierTest extends Thread{

    @Override
    public void run() {
        System.out.println("开始整理数据");
    }


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CycliBarrierTest());

        new Thread(new CycliBarrierDemo(cyclicBarrier, "file1")).start();
        new Thread(new CycliBarrierDemo(cyclicBarrier, "file2")).start();
        new Thread(new CycliBarrierDemo(cyclicBarrier, "file3")).start();

    }
}
