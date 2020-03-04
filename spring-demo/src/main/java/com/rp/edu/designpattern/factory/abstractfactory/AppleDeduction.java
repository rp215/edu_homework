package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class AppleDeduction implements IDeduction{
    @Override
    public void deduction() {
        System.out.println("苹果支付扣款...");
    }
}
