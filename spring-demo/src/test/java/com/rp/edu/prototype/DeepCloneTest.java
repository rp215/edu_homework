package com.rp.edu.prototype;

import com.rp.edu.designpattern.propotype.deep.DeepCloneWithJson;
import com.rp.edu.designpattern.propotype.deep.DeepCloneWithSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @功能描述：
 */
public class DeepCloneTest {

    public static void main(String[] args)  {
//        DeepCloneWithSerialize deep = new DeepCloneWithSerialize();
        DeepCloneWithJson deep = new DeepCloneWithJson();
        deep.setAge(18);
        deep.setName("rp");
        List<String> list = new ArrayList<>(10);
        list.add("足球");
        deep.setHobbys(list);

//        DeepCloneWithSerialize clone = (DeepCloneWithSerialize) deep.deepClone();

        DeepCloneWithJson clone = (DeepCloneWithJson) deep.deepWithJson();
        System.out.println(deep == clone);


        clone.getHobbys().add("篮球");
        clone.getHobbys().add("羽毛球");

        System.out.println("原生对象：" + deep);
        System.out.println("克隆对象：" + clone);
    }

}
