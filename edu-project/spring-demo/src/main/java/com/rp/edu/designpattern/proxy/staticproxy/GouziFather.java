package com.rp.edu.designpattern.proxy.staticproxy;

/**
 * 静态代理类：在编译期间就需要确定委托类的对象，意味着每个代理类代理固定的委托类
 * 缺点：代理类和委托类都实现了同样的接口，代码冗余，而且当接口发生变化时，委托类和代理类都需要修改。
 *      代理对象只服务于一种类型的对象，如果要服务多类型的对象，势必要为每一种对象都进行代理。
 *
 */
public class GouziFather implements IPeople{
    private Gouzi target;

    /**
     * 编译期间就确定需要的代理的委托类
     * @param target
     */
    public GouziFather(Gouzi target) {
        this.target = target;
    }

    /**
     * 代理类可以在调用委托类的方法之前或者之后做一些其它的处理
     */
    @Override
    public void findLove() {
        before();
        this.target.findLove();
        after();
    }

    private void after() {
        System.out.println("相亲成功，开始约会");
    }

    private void before() {
        System.out.println("父亲开始物色");
    }
}
