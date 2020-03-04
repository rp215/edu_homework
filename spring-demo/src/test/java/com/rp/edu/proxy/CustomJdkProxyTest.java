package com.rp.edu.proxy;


import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.ClientProxy;
import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.Gouzi;
import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople;

/**
 * CGLIB 继承的方式，覆盖父类的方法
 * JDK 采用实现的方式，必须要求代理类的目标对象一定要实现一个接口
 * 两者的思想：都是通过生成字节码，重组成一个新的类
 */
public class CustomJdkProxyTest {


    public static void main(String[] args) {
        IPeople proxy = new ClientProxy().getInstance(new Gouzi());
        proxy.findLove();
        proxy.query("170", 25);


    }
}
