package com.rp.edu.designpattern.factory.factorymethod;

/**
 * @功能描述：
 */
public class TestDemo {
    public static void main(String[] args) {
        /* 各自的工厂创建各自的产品 */
        /* 不足：每增加一种产品就需要再创建对应的工厂 */
//        MainFactory factory = new WechatFactory();
        IMainFactory factory = new AliFactory();
        factory.create().pay();
    }
}
