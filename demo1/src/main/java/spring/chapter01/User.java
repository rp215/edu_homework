package spring.chapter01;

import java.util.List;

/**
 * @author：renpeng
 * @date：2019/3/13
 */
public class User {
    private String name;

    private int age;

    private List list;

    /*
     * 使用构造注入
     * 提供带参的构造函数
     * */
    public User(String name, int age, List list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }




    /*
    * 使用设置注入
    * 提供默认无参的构造函数（因为在定义了带参的构造函数，默认的无参构造函数就没有了，你就必须要加一个无参构造函数，方便去new对象的时候使用）
    * 为属性提供setter方法
    * */

    public User() {
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[User-->name:" + name + ";age:" + age + ";list:" + list + "]";
    }


}
