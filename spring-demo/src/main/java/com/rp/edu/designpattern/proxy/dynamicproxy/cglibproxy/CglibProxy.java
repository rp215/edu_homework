package com.rp.edu.designpattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理是代理类去继承目标类，然后重写其中目标类的方法，这样也可以保证代理类拥有目标类的同名方法
 * CGLib 代理执行代理方法的效率之所以比 JDK 的高，是因为 CGlib 采用了 FastClass 机制，它的原
 * 理简单来说就是：为代理类和被代理类各生成一个类，这个类会为代理类或被代理类的方法分配一个
 * index（int 类型）；这个 index 当作一个入参，FastClass 就可以直接定位要调用的方法并直接进行调
 * 用，省去了反射调用，所以调用效率比 JDK 代理通过反射调用高。
 * 注：CGLIB不成代理目标类中被final修饰的方法
 */
public class CglibProxy implements MethodInterceptor {
    public Object getInstance(Class<?> clazz) {
        /* 通过CGLIB动态代理获取代理对象的过程，可以理解为创建代理类的类库 */
        Enhancer enhancer = new Enhancer();
        /* 将目标类设置为父类，代理类和目标类是继承关系 */
        enhancer.setSuperclass(clazz);
        /* 设置enhancer的回调对象 */
        enhancer.setCallback(this);
        /* 创建代理对象 */
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置处理");
        /* 通过FastClass机制调用目标类的方法 */
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("插入后置处理");
        return obj;
    }
}
