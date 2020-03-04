package com.rp.edu.designpattern.propotype;

import lombok.Data;

import java.util.List;

/**
 * 以系统中已存在的一个对象为原型，直接基于内存二进制流进行拷贝，
 * 无需再经历耗时的对象初始化过程（不调用构造函数），性能提升许多
 *
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
public class PrototypePojo implements Cloneable{
    private int age;
    private String name;
    private List<String> hobbys;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
