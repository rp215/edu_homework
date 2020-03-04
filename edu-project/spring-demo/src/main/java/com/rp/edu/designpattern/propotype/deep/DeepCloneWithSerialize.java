package com.rp.edu.designpattern.propotype.deep;

import com.rp.edu.designpattern.propotype.PrototypePojo;
import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * 原型模式，与单例模式是对立的，意味着每次获取实例都是一个全新的，不需要通过构造函数去创建实例
 * 分为浅克隆和深克隆，实现了JDK的Cloneable接口都是浅克隆。
 * 浅克隆：如果原生对象的某个属性是引用类型，则克隆对象克隆的是该引用的地址，并不是具体的值
 * 深克隆：通过序列化和json的方式可以实现深克隆，意味着克隆的是原生对象中每个属性具体的值（包括引用类型）
 * clone() 在Object实现，是一个native方法，即实现字节码的clone
 *
 * 场景：1、创建类消耗的资源较多；2、构造函数传参比较复杂；3、new 过程比较复杂
 */

/**
 * 要使用 @Data 注解要先引入lombok，lombok是一个工具类库，可以用简单的注解形式来简化代码，
 * 提高开发效率。使用这个注解可以在编译期间提供以下的方法
 * 1、所有属性的get和set方法
 * 2、toString 方法
 * 3、hashCode方法
 * 4、equals方法
 */
@Data
public class DeepCloneWithSerialize implements Cloneable, Serializable {
    private int age;
    private String name;
    private List<String> hobbys;

    /**
     * 通过序列化实现深度克隆，在单例模式中，如果在序列化/反序列化的过程中，对象存在readResolve()方法，
     * 反序列化就不会创建新的实例，因此不添加这个方法，那么反序列化就会创建新的实例
     * 可以实现深度克隆的目的
     * @return
     */
    public Object deepClone() {
        try{
            /* ByteArrayOutputStream是用来缓存数据的（数据写入的目标（output stream原义）），
            向它的内部缓冲区写入数据，缓冲区自动增长，当写入完成时可以从中提取数据。 */
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            /* ByteArrayInputStream 包含一个内部缓冲区，该缓冲区包含从流中读取的字节 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String toString() {
        return "PrototypePojo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbys=" + hobbys +
                '}';
    }
}
