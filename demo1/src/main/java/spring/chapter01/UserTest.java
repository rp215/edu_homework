package spring.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class UserTest {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(ctx.getBean("user"));
        System.out.println(ctx.getBean("user1"));

    }
}
