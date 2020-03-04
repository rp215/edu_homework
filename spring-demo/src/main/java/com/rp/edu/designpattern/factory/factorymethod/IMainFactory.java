package com.rp.edu.designpattern.factory.factorymethod;

import com.rp.edu.designpattern.factory.until.IPayment;

/**
 * @功能描述：工厂的工厂
 */
public interface IMainFactory {
    IPayment create();
}
