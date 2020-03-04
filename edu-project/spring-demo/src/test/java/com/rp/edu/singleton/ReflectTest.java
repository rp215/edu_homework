package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.lazy.LazyInnerClassSingleton;
import com.rp.edu.designpattern.singleton.register.ContainerSigleton;

import java.lang.reflect.Constructor;

/**
 * @功能描述：通过反射拿到构造，强制访问，去创建实例
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
//            Class<?> clazz = LazyInnerClassSingleton.class;
            Class<?> clazz = ContainerSigleton.class;
            Constructor c = clazz.getDeclaredConstructor();

            /* 强制访问 */
            c.setAccessible(true);
            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();

            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
