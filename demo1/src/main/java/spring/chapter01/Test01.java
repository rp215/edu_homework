package spring.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class Test01 {
    public static void main(String[] args) {
        //加载spring应用上下文
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

        UserController userController = (UserController) ctx.getBean("usercontroller");
        userController.sys();

    }
}
