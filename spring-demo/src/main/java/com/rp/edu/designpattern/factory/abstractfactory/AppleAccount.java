package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class AppleAccount implements IAccount{
    @Override
    public void account() {
        System.out.println("苹果支付入账...");
    }
}
