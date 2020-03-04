package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.register.ContainerSigleton;

/**
 * @功能描述：
 */
public class ThreadContainerSingletonTest extends Thread{
    @Override
    public void run() {
        Object instance =
                ContainerSigleton.getInstance("com.rp.edu.singleton.User");

        System.out.println(instance);
    }
}
