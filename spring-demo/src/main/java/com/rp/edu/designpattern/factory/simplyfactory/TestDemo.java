package com.rp.edu.designpattern.factory.simplyfactory;

import com.rp.edu.designpattern.factory.until.IPayment;
import com.rp.edu.designpattern.factory.until.UnionPay;

/**
 * @功能描述：
 */
public class TestDemo {
    public static void main(String[] args) {

        // V1
        /*PaymentFactory factory = new PaymentFactory();
        IPayment payment = factory.paymentV1("union");
        payment.pay();*/

        // V2
        PaymentFactory factory = new PaymentFactory();
        IPayment payment = factory.paymentV2(UnionPay.class);
        payment.pay();
    }
}
