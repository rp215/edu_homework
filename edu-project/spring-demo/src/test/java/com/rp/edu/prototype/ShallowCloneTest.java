package com.rp.edu.prototype;

import com.rp.edu.designpattern.propotype.PrototypePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @功能描述：
 */
public class ShallowCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        PrototypePojo pojo = new PrototypePojo();
        pojo.setAge(18);
        pojo.setName("rp");
        List<String> list = new ArrayList<>(10);
        list.add("足球");
        pojo.setHobbys(list);

        PrototypePojo clone = (PrototypePojo) pojo.clone();
        clone.getHobbys().add("篮球");

        System.out.println(pojo == clone);
        System.out.println("原生对象：" + pojo);
        System.out.println("克隆对象：" + clone);

        /* 原生对象和克隆对象的地址不同，但是属性hobbys是引用类型，克隆的是其地址，并不是本身的值 */
        System.out.println(pojo.getHobbys() == clone.getHobbys());
    }
}
