package com.rp.edu.designpattern.factory.until;

/**
 * @功能描述：
 */
public class WechatPay implements IPayment{
    @Override
    public void pay() {
        System.out.println("微信支付...");
    }
}
