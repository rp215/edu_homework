package com.rp.edu.designpattern.factory.factorymethod;

import com.rp.edu.designpattern.factory.until.AliPay;
import com.rp.edu.designpattern.factory.until.IPayment;

/**
 * @功能描述：
 */
public class AliFactory implements IMainFactory{

    @Override
    public IPayment create() {
        return new AliPay();
    }
}
