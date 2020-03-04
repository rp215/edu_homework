package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.hungry.HungryReversionDemo;

/**
 * @功能描述：
 */
public class HungryTest {
    public static void main(String[] args) {

        System.out.println(HungryReversionDemo.getInstance());
        System.out.println(HungryReversionDemo.getInstance());

    }
}
