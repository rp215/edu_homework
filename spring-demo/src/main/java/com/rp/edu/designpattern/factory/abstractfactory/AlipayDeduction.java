package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class AlipayDeduction implements IDeduction{
    @Override
    public void deduction() {
        System.out.println("支付宝支付扣款...");
    }
}
