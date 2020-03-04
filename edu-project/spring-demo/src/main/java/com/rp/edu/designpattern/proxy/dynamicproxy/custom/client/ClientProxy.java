package com.rp.edu.designpattern.proxy.dynamicproxy.custom.client;

import com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy.CustomClassLoader;
import com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy.CustomInvocationHandler;
import com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy.CustomProxy;

import java.lang.reflect.Method;

/**
 * @功能描述：
 */
public class ClientProxy implements CustomInvocationHandler {
    private IPeople target;

    public IPeople getInstance(IPeople target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPeople) CustomProxy.newProxyInstance(new CustomClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
