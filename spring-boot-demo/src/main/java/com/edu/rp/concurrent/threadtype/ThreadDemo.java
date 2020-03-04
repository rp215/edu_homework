package com.edu.rp.concurrent.threadtype;

/**
 * @功能描述：
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println("extends Thread");
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        t1.start();
        t2.start();
    }
}
