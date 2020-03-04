package com.rp.edu.designpattern.factory.until;

/**
 * @功能描述：
 */
public class AliPay implements IPayment{
    @Override
    public void pay() {
        System.out.println("支付宝支付...");
    }
}
