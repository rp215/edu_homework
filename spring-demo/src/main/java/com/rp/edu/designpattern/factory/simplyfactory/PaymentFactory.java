package com.rp.edu.designpattern.factory.simplyfactory;

import com.rp.edu.designpattern.factory.until.AliPay;
import com.rp.edu.designpattern.factory.until.IPayment;
import com.rp.edu.designpattern.factory.until.UnionPay;
import com.rp.edu.designpattern.factory.until.WechatPay;

/**
 * @功能描述：产品的工厂
 */
public class PaymentFactory {

    /**
     * @功能描述：版本一，基于用户输入的支付方式构建对应的产品
     * @参数说明：[name]
     * @创建时间：2020/2/24
     */
    public IPayment paymentV1(String name) {
        if ("wechat".equals(name)) {
            return new WechatPay();
        } else if ("ali".equals(name)) {
            return new AliPay();
        } else if ("union".equals(name)) {
            return new UnionPay();
        }

        return null;
    }


    /**
     * @功能描述：版本二，避免用户输入错误，直接在应用层做校验
     * @参数说明：[clazz]
     * @创建时间：2020/2/24
     */
    public IPayment paymentV2(Class<? extends IPayment> clazz) {
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
