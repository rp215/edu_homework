package com.rp.edu.designpattern.factory.until;

/**
 * @功能描述：
 */
public class ApplePay implements IPayment{
    @Override
    public void pay() {
        System.out.println("Apple支付...");
    }
}
