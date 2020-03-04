package com.rp.edu.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @功能描述：此单例仅是在当前容器的生态内，意味着通过全局唯一点（容器中get）去获取实例可以保证单例，但是反射也会出现问题
 */
public class ContainerSigleton {
    private ContainerSigleton() {}

    /** 存在线程安全问题：
     * 当多个线程去执行的时候，给我们的假象是容器生态中只产生了一个对象实例，但是实际上是当多个线程
     * 同时访问到 if (!ioc.containsKey(className)) { 时，都会去创建对象实例，只不过下一个线程创建完的
      * 对象实例会替换了前一个线程所创建的对象实例
      *
      */
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        /* 多个线程访问，只有一个线程拿到锁，并且创建完对象实例，并put 到 ioc 容器中
         * 当其它线程获取到锁之后，直接从ioc 中 get
          * */
        if (!ioc.containsKey(className)) {
            synchronized (ioc) {
                if (!ioc.containsKey(className)) {
                    Object instance = null;
                    try {
                        /* ioc 容器中不存在，先去创建，并放到容器中，最后返回 */
                        instance = Class.forName(className).newInstance();
                        ioc.put(className, instance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return instance;
                }
            }
        }
        /* 存在直接从容器中get */
        return ioc.get(className);
    }
}
