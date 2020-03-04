package com.rp.edu.designpattern.factory.abstractfactory;

/**
 * @功能描述：
 */
public abstract class AbstractFactory {

    public void initData() {
        System.out.println("初始化数据");
    }

    /**
     * 扣款
     */
    protected abstract IDeduction creDeduction();

    /**
     * 入账
     */
    protected abstract IAccount creAccount();
}
