package com.rp.edu.designpattern.singleton.serialize;

import java.io.Serializable;

/**
 * @功能描述：
 *
 * 序列化：
 * 将内存中对象的状态转化为字节码的形式
 * 然后将字节码通过IO输出流的形式写到磁盘上，转变成一个文件，永久的保存（持久化）
 *
 * 反序列化：
 * 将持久化的字节码内容通过IO输入流读取到内存
 * 再将它转换成Java对象
 *
 */
public class SerializeSigleton implements Serializable {

    private static SerializeSigleton instance = new SerializeSigleton();

    private SerializeSigleton() {}

    public static SerializeSigleton getInstance() {
        return instance;
    }

    /***
     * 如果增加了readResolve 方法之后，在通过输入流去readObject 对象的时候会直接调用 readResolve() 直接返回instance
     * 如果没有readResolve() 方法，源码里会直接调用 newInstance()，重新分配对象
     */
    private Object readResolve() {return instance;}
}
