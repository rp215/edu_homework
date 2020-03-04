package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.register.ContainerSigleton;

/**
 * @功能描述：
 */
public class ContainerTest {
    public static void main(String[] args) {

        /*Object instance1 = ContainerSigleton.getInstance("com.rp.edu.singleton.User");
        Object instance2 = ContainerSigleton.getInstance("com.rp.edu.singleton.User");

        System.out.println(instance1 == instance2);*/

        new Thread(new ThreadContainerSingletonTest(), "Thread->0").start();
        new Thread(new ThreadContainerSingletonTest(), "Thread->1").start();
        new Thread(new ThreadContainerSingletonTest(), "Thread->2").start();

    }
}
