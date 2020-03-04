package spring.chapter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class LoginTest {

    public static void main(String[] args) {

        //加载spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAnnotation.xml");
        LoginController loginController = (LoginController) ctx.getBean("loginController");
        loginController.print();

        //输出结果：
//        实例化LoginDao
//        实例化LoginServiceImpl
//        实例化LoginController
    }
}
