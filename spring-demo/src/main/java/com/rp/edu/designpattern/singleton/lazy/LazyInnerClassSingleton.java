package com.rp.edu.designpattern.singleton.lazy;

/**
 * @功能描述：静态内部类运用了Java语法的特点，内部类再使用时才会去加载
 * 一般类加载，会扫描 classpath下的  LazyInnerClassSingleton.class
 *                                 LazyInnerClassSingleton$LazyInner.class
 *  优点：性能高，空间浪费低，写法优雅
 *  缺点：被反射破坏
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {

        /* 反射破坏单例，在构造里面加个判断，虽然解决了被反射破坏的问题，但是代码不优雅 */
        if (null != LazyInner.INSTANCE) {
            throw new RuntimeException("非法访问");
        }

    }

    public static LazyInnerClassSingleton getInstance() {
        return LazyInner.INSTANCE;
    }

    private static class LazyInner{
        /* 虽然和饿汉式单例（初始化类时就已经在jvm中存在）很像，但是属于懒汉式，在使用的时候才会去加载 */
        private static final LazyInnerClassSingleton INSTANCE =
                new LazyInnerClassSingleton();
    }
}
