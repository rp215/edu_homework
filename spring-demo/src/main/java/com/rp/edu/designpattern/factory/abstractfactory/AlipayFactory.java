package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：支付宝支付
 */
public class AlipayFactory extends AbstractFactory{
    @Override
    protected IDeduction creDeduction() {
        super.initData();
        return new AlipayDeduction();
    }

    @Override
    protected IAccount creAccount() {
        super.initData();
        return new AlipayAccount();
    }
}
