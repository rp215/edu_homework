package com.rp.edu.designpattern.singleton.threadlocal;

/**
 * @功能描述：
 */
public class ThreadLocalSingleton {
    /**
     * 通过一个匿名内部类去重写initialValue()
     * ThreadLocal 将所有的对象全部放在 ThreadLocalMap 中，
     * 为每个线程都提供一个对象，实际上是以空间换时间来实现线程隔离的。
     * 将线程作为key，去获取对象实例，在一个线程内保证单例。
     */
    private static ThreadLocal<ThreadLocalSingleton> local =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };
    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return local.get();
    }
}
