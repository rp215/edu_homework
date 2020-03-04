package com.rp.edu.designpattern.propotype.deep;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;


/**
 * 通过Json实现深度克隆，使用json的方式速度较快，但无法应用于有自定义类型的属性的对象
 */
@Data
public class DeepCloneWithJson {
    private int age;
    private String name;
    private List<String> hobbys;

    public Object deepWithJson() {
        String jsonStr = JSON.toJSONString(this);
        return JSON.parseObject(jsonStr, DeepCloneWithJson.class);
    }

    @Override
    public String toString() {
        return "DeepCloneWithJson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbys=" + hobbys +
                '}';
    }
}
