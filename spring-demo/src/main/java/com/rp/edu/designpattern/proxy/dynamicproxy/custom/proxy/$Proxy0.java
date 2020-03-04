package com.rp.edu.designpattern.proxy.dynamicproxy.custom.proxy;
import com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople;
import java.lang.reflect.*;
public class $Proxy0 implements com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople {
    CustomInvocationHandler h;
    public $Proxy0(CustomInvocationHandler h) {
        this.h = h;
    }
    @Override
    public void query(java.lang.String string, java.lang.Integer integer) {
        try{
            Method method = com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople.class.getMethod("query", new Class[]{java.lang.String.class, java.lang.Integer.class});
            this.h.invoke(this, method, new Object[]{string, integer});
            return;
        } catch (RuntimeException | Error var2){
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
    @Override
    public void findLove() {
        try{
            Method method = com.rp.edu.designpattern.proxy.dynamicproxy.custom.client.IPeople.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, method, new Object[]{});
            return;
        } catch (RuntimeException | Error var2){
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
}