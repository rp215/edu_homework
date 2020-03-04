package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.lazy.LazyDemo;
import com.rp.edu.designpattern.singleton.lazy.LazySynchronizedDemo;

/**
 * @功能描述：
 */
public class ThreadSingletonTest extends Thread{

    @Override
    public void run() {

        LazySynchronizedDemo instance = LazySynchronizedDemo.getInstance();
        System.out.println(Thread.currentThread().getName() + "->" + instance);

    }
}
