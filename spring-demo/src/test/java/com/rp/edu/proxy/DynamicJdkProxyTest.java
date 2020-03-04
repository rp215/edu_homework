package com.rp.edu.proxy;

import com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy.Erdan;
import com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy.IPeople;
import com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy.JdkProxy;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @功能描述：
 */
public class DynamicJdkProxyTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
//        IPeople proxy = jdkProxy.getInstance(new Gouzi());
        IPeople proxy = jdkProxy.getInstance(new Erdan());
        /* 代理类proxy调用findLove->  JdkProxy.invoke() -> target( new Erdan()的findLove() )*/
        proxy.findLove();


        /* 生成字节码工具 */
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPeople.class});
        try {
            FileOutputStream fos = new FileOutputStream("E://$Proxy0.class");
            fos.write(bytes);
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
