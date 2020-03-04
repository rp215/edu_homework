package com.rp.edu.designpattern.singleton.lazy;

/**
 * @功能描述：双重检查，为了避免多个线程的等待，我们设置双重检查，让等待的线程在第一个检查内等待
 * 优点：解决了线程的安全性，性能提高
 * 缺点：代码不优雅
 */
public class LazySynchronizedDoubleCheck {

    /* 使用volatile修饰共享变量，防止发生指令重排序 */
    private volatile static LazySynchronizedDoubleCheck instance;

    private LazySynchronizedDoubleCheck() {}

    public static LazySynchronizedDoubleCheck getInstance() {
        /* 假设第一次只有一个线程进入，并且创建了对象实例，而后续再进入就不会阻塞，直接返回对象实例
         * 相对来说是提高了性能
          * 但是假设有1000个线程同时进入，那肯定会阻塞*/
        if (null == instance) {
            synchronized (LazySynchronizedDoubleCheck.class) {
                if (null == instance) {
                    /* 可能会发生重排序问题 */
                    instance = new LazySynchronizedDoubleCheck();
                }
            }
        }

        return instance;
    }

    /*
     * synchronized 本身在同一个监视器对象的情况下可以保证可见性：
     * 加锁前清空工作内存的共享变量，直接从主存中读取
     * 解锁前将共享变量的最新值刷回到主存
     * ①：private volatile static LazySynchronizedDoubleCheck instance;
     * ②：new LazySynchronizedDoubleCheck();
     * ③：instance 的值指向 ②的内存地址
     * 这里 ① 和 ② 都会分配空间，但是由于多线程环境下，线程运行再抢夺CPU资源的情况下执行的顺序不确定
     * 可能会先执行②，再执行①
      *
      * */

}
