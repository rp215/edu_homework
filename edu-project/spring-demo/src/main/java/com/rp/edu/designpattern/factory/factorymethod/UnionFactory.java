package com.rp.edu.designpattern.factory.factorymethod;

import com.rp.edu.designpattern.factory.until.IPayment;
import com.rp.edu.designpattern.factory.until.UnionPay;

/**
 * @功能描述：
 */
public class UnionFactory implements IMainFactory{
    @Override
    public IPayment create() {
        return new UnionPay();
    }
}
