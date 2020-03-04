package com.edu.rp.concurrent.threadtype;

/**
 * @功能描述：
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": implements Runnable");
    }

    public static void main(String[] args) {
        RunnableDemo target = new RunnableDemo();
        /* 自定义线程名称，纠错好定位 */
        new Thread(target, "Thread0").start();
        /* 默认的名字，Thread类的nextThreadNum()，且是同步的，对一个int类型对对变量递增 */
        new Thread(target).start();
    }

}
