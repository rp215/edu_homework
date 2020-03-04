package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public class WechatDeduction implements IDeduction{
    @Override
    public void deduction() {
        System.out.println("微信支付扣款...");
    }
}
