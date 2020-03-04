package com.rp.edu.designpattern.proxy.dynamicproxy.custom.client;


/**
 * @功能描述：
 */
public class Gouzi implements IPeople {
    @Override
    public void findLove() {
        System.out.println("要求：漂亮小姐姐~");
    }

    @Override
    public void query(String str, Integer age) {
        System.out.println("寻找年龄小于" + age + "，身高大于" + str + "的漂亮小姐姐~");
    }


}
