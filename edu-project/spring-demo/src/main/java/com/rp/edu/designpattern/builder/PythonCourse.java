package com.rp.edu.designpattern.builder;

/**
 * @功能描述：
 */
public class PythonCourse implements ICourse{
    @Override
    public ICourse addPpt() {
        return this;
    }

    @Override
    public ICourse addVideo() {
        System.out.println("【Python录播视频】");
        return this;
    }

    @Override
    public ICourse addNote() {
        System.out.println("【Python课堂笔记】");
        return this;
    }
}
