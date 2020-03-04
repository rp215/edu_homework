package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class AlipayAccount implements IAccount{
    @Override
    public void account() {
        System.out.println("支付宝支付入账...");
    }
}
