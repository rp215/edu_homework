package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：微信支付
 */
public class WechatFactory extends AbstractFactory{
    @Override
    protected IDeduction creDeduction() {
        super.initData();
        return new WechatDeduction();
    }

    @Override
    protected IAccount creAccount() {
        super.initData();
        return new WechatAccount();
    }
}
