package com.rp.edu.designpattern.singleton.lazy;

/**
 * @功能描述：通过加锁，保证线程的同步，而此时又会带来性能上的损耗
 */
public class LazySynchronizedDemo {
    private static LazySynchronizedDemo instance;
    private LazySynchronizedDemo() {}

    /*
     * 当Thread-1 获取锁是，Thread-3 是阻塞状态，该线程的状态是MONITOR
      * 优点：保证了多线程环境下的只创建一份实例
      * 缺点：假设有1000个线程访问，999个线程会被阻塞
      * */

    public static LazySynchronizedDemo getInstance(){
        synchronized (LazySynchronizedDemo.class) {
            if (null == instance) {
                instance = new LazySynchronizedDemo();
            }
        }
        return instance;
    }
}
