package com.rp.edu.designpattern.singleton.hungry;

/**
 * @功能描述：
 *
 * 和最初版的饿汉式单例区别不大，只不过在静态块中创建实例
 */
public class HungryReversionDemo {
    private static HungryReversionDemo instance;

    static {
        instance = new HungryReversionDemo();
    }

    private HungryReversionDemo(){};

    /* 全局访问点 */
    public static HungryReversionDemo getInstance() {
        return instance;
    }
}
