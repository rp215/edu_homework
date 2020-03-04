package com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 动态代理：一种机制的实现，分为jdk（代理接口）和CGLIB（代理类，）
 * 代理一个接口下的多个实现类，不需要事先知道具体的委托类的对象，因为代理的是接口，所以代理的类必须实现接口
 * 从$Proxy0的源码可以看出，动态代理类不仅代理了显示定义的接口中的方法，
 * 而且还代理了java的根类Object中的继承而来的equals()、hashcode()、toString()这三个方法，并且仅此三个方法。
 *
 * */
public class JdkProxy implements InvocationHandler {
    private IPeople target;

    public IPeople getInstance(IPeople target) {
        this.target = target;

        /* 获取到委托类的class对象 */
        Class<?> clazz = target.getClass();

        /* 生成的代理对象result在运行期间会自动调用invoke方法 */
        Object result = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

        return (IPeople) result;
    }

    /**
     * 被代理的对象$Proxy0继承了Proxy类，并且实现了IPeople接口，因此$Proxy0必然实现了findLove()
     * 在实现的findLove() 中可以看到内部的调用-> super.h.invoke(this, mXX, null);
     * super-> Proxy类，而Proxy类中的h，在生成代理类对象的方法即
     *         Proxy.newProxyInstance(...) 方法中赋值，意味着h->JdkProxy
     * this-> 代理代理对象本身$Proxy0
     * mXX-> 在代理类$Proxy0的静态块中通过反射赋值，调用具体的哪个方法
     * method.invoke中传this.target的原因是，当代理类生成之后经过调用，最后肯定是需要执行委托类的方法。
     * 总结：$Proxy0.findLove() -> JdkProxy.invoke() -> target.findLove()
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }


    /**
     * 以下就是生成的代理类对象$Proxy0
     */

    /*
    import com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy.IPeople;
    import java.lang.reflect.InvocationHandler;
    import java.lang.reflect.Method;
    import java.lang.reflect.Proxy;
    import java.lang.reflect.UndeclaredThrowableException;

    public final class $Proxy0 extends Proxy implements IPeople {
        private static Method m1;
        private static Method m3;
        private static Method m2;
        private static Method m0;

        public $Proxy0(InvocationHandler var1) throws  {
            super(var1);
        }

        public final boolean equals(Object var1) throws  {
            try {
                return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
            } catch (RuntimeException | Error var3) {
                throw var3;
            } catch (Throwable var4) {
                throw new UndeclaredThrowableException(var4);
            }
        }

        public final void findLove() throws  {
            try {
                super.h.invoke(this, m3, (Object[])null);
            } catch (RuntimeException | Error var2) {
                throw var2;
            } catch (Throwable var3) {
                throw new UndeclaredThrowableException(var3);
            }
        }

        public final String toString() throws  {
            try {
                return (String)super.h.invoke(this, m2, (Object[])null);
            } catch (RuntimeException | Error var2) {
                throw var2;
            } catch (Throwable var3) {
                throw new UndeclaredThrowableException(var3);
            }
        }

        public final int hashCode() throws  {
            try {
                return (Integer)super.h.invoke(this, m0, (Object[])null);
            } catch (RuntimeException | Error var2) {
                throw var2;
            } catch (Throwable var3) {
                throw new UndeclaredThrowableException(var3);
            }
        }

        static {
            try {
                m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
                m3 = Class.forName("com.rp.edu.designpattern.proxy.dynamicproxy.jdkproxy.IPeople").getMethod("findLove");
                m2 = Class.forName("java.lang.Object").getMethod("toString");
                m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            } catch (NoSuchMethodException var2) {
                throw new NoSuchMethodError(var2.getMessage());
            } catch (ClassNotFoundException var3) {
                throw new NoClassDefFoundError(var3.getMessage());
            }
        }
    }*/

}
