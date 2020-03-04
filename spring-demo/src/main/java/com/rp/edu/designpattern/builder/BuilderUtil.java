package com.rp.edu.designpattern.builder;

/**
 * 建造者模式（链式编程）：将一个对象的构建过程和表示分离，将构建过程开放，而不需要用户关心细节的实现
 * 优点：封装好，创建和使用分离
 * 缺点：产生多余的build对象，修改较为麻烦，产品变化，建造者也需要修改
 *
 * 场景：相同的方法，不同的执行顺序，产生不同的结果时；
 *       当初始化一个对象特别复杂，参数多，而且很多参数都具有默认值时。
 *       购买汽车，配置不同，产生的对象都是汽车，只不过将构建的过程公开，让用户参与（高配、低配）
 *
 * 建造者模式主要有四个角色:
 * Product:要创建的产品类对象
 * Builder:建造者的抽象类，规范产品对象的各个组成部分的建造，一般由子类实现具体的建造过程。
 * ConcreteBuilder:具体的Builder类，根据不同的业务逻辑，具体化对象的各个组成部分的创建。
 * Director：调用具体的建造者，来创建对象的各个部分，在指导者中不涉及具体产品的信息，
 *           只负责保证对象各部分完整创建或按某种顺序创建。
 *
 *
 */
public class BuilderUtil implements IBuilder{

    @Override
    public ICourse buildForJava() {
        ICourse course = new JavaCourse()
                .addNote()
                .addPpt()
                .addVideo();

        return course;
    }

    @Override
    public ICourse buildForPython() {
        ICourse course = new PythonCourse()
                .addNote()
                .addVideo();

        return course;
    }
}
