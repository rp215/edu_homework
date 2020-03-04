package com.rp.edu.designpattern.singleton.register;

import java.lang.reflect.Constructor;

/**
 * Cannot reflectively create enum objects
 * enum 源码中解释：被enum 修饰符修饰不能被反射所创建，从jdk底层就规范
 *
 */
public enum  EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {

        try {
            Class clazz = EnumSingleton.class;
            System.out.println(clazz);

            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);

            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();

            System.out.println(instance1);
            System.out.println(instance2);
        } catch (Exception e) {
            e.printStackTrace();

            /**
             * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
             * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
             * 	at com.rp.edu.designpattern.singleton.register.EnumSingleton.main(EnumSingleton.java:23)
             */
        }
    }
}
