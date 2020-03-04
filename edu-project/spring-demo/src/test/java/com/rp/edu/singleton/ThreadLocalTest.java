package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @功能描述：
 */
public class ThreadLocalTest {
    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

    }
}
