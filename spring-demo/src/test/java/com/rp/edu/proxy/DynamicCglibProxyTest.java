package com.rp.edu.proxy;

import com.rp.edu.designpattern.proxy.dynamicproxy.cglibproxy.CglibProxy;
import com.rp.edu.designpattern.proxy.dynamicproxy.cglibproxy.Target;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 *
 */
public class DynamicCglibProxyTest {
    public static void main(String[] args) {
        Target proxy = (Target) new CglibProxy().getInstance(Target.class);
        /* 生成的代理类proxy是target类的子类 */
        proxy.print();


        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\cglib");
    }
}
