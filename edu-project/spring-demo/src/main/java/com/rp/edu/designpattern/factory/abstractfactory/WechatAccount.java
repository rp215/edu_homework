package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class WechatAccount implements IAccount{
    @Override
    public void account() {
        System.out.println("微信支付入账...");
    }
}
