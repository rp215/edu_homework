package com.rp.edu.designpattern.singleton.hungry;

/**
 * @功能描述：饿汉式单例
 *
 * 优点：类加载即初始化实例，某些场景提高了性能
 * 缺点：如果实例并未被使用，则造成了内存空间的浪费
 */
public class HungryDemo {
    private static HungryDemo instance = new HungryDemo();

    private HungryDemo(){}

    public static HungryDemo getInstance() {
        return instance;
    }
}
