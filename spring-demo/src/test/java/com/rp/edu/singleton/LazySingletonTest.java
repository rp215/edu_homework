package com.rp.edu.singleton;

/**
 * @功能描述：
 */
public class LazySingletonTest {
    public static void main(String[] args) {

        new Thread(new ThreadSingletonTest()).start();
        new Thread(new ThreadSingletonTest()).start();

    }
}
