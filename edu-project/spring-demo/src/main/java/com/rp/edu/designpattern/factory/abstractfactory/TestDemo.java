package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class TestDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new AlipayFactory();
//        AbstractFactory factory = new WechatFactory();
//        AbstractFactory factory = new AppleFactory();
        factory.creDeduction().deduction();
        factory.creAccount().account();
    }
}
