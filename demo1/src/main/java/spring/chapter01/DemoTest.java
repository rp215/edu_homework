package spring.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：renpeng
 * @date：2019/3/13
 */
public class DemoTest {

    public static void main(String[] args) {

        /*
        * Bean的生命周期：
        * Spring容器可以管理 singleton 作用域的 Bean 的生命周期，在此作用域下， Spring 能够精确地知道
        * 该 Bean 何时被创建，何时初始化完成以及何时被销毁。
        * 对于 prototype 作用域的 Bean, Spring 只负责创建，当容器创建了 Bean 实例后，
        * Bean 的实例就交给客户端代码来管理， Spring 容器将不再跟踪其生命周期。
        * 每次客户端请求 prototype 作用域的 Bean 时， Spring 容器都会创建一个新的实例，
        * 并且不会管理那些被配置成 prototype 作用域的 Bean 的生命周期。
        *
        * */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        // 构造器实例化
//        System.out.println(ctx.getBean("user"));
        // 静态工厂实例化
//        System.out.println(ctx.getBean("staticbeanFactory"));
        // 实例工厂方式实例化bean
//        System.out.println(ctx.getBean("user"));

    }
}
