package com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy;

import java.lang.reflect.Method;

/**
 * @功能描述：
 */
public interface CustomInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
