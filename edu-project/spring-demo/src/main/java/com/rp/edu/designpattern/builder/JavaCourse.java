package com.rp.edu.designpattern.builder;

/**
 * @功能描述：
 */
public class JavaCourse implements ICourse{

    @Override
    public ICourse addPpt() {
        System.out.println("【Java设计模式】");
        return this;
    }

    @Override
    public ICourse addVideo() {
        System.out.println("【Java录播视频】");
        return this;
    }

    @Override
    public ICourse addNote() {
        System.out.println("【Java课堂源码】");
        return this;
    }
}
