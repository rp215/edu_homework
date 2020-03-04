package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：苹果系统支付
 */
public class AppleFactory extends AbstractFactory{
    @Override
    protected IDeduction creDeduction() {
        super.initData();
        return new AppleDeduction();
    }

    @Override
    protected IAccount creAccount() {
        super.initData();
        return new AppleAccount();
    }
}
