package com.rp.edu.designpattern.factory.until;

/**
 * @功能描述：
 */
public class UnionPay implements IPayment{
    @Override
    public void pay() {
        System.out.println("银联支付...");
    }
}
