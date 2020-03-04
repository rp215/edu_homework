package com.rp.edu.designpattern.singleton.lazy;

/**
 * @功能描述：懒汉式单例
 * 优点：只有再使用的是才会去创建实例
 */
public class LazyDemo {

    private static LazyDemo instance;

    private LazyDemo() {};

    /*
     * 多线程环境下，展示的结果是同一个实例，但并非是我们所认为的只产生了一个实例,同一个实例的两种表现：
     * ①：线程按照执行顺，ThreadA进入if (null == instance) {执行完 instance = new LazyDemo();之后，
     * ThreadB再执行，次吃不会进入if条件内，所以只产生了一个实例，但是多线程环境下，线程的执行顺序是无法预知的，
     * 会产生CPU的切换。
     * ②：当ThreadA和ThreadB 同时进入  if (null == instance) ，ThreadA 运行 instance = new LazyDemo();
     * 创建了一个实例，假设是 @xxx546，而此时ThreadB 也会去执行 instance = new LazyDemo(); 此时又会创建
     * 一个实例，假设是 @xxx547，这也就意味着 @xxx547 把 @xxx546 给覆盖了，导致我们看的结果是同一个实例
      *
      * */

    public static LazyDemo getInstance() {
        if (null == instance) {
            instance = new LazyDemo();
        }
        return instance;
    }
}
