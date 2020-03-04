package com.rp.edu.designpattern.factory.factorymethod;

import com.rp.edu.designpattern.factory.until.IPayment;
import com.rp.edu.designpattern.factory.until.WechatPay;

/**
 * @功能描述：
 */
public class WechatFactory implements IMainFactory{

    @Override
    public IPayment create() {
        return new WechatPay();
    }
}
