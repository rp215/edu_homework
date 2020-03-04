package lock.redislock;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author：renpeng
 * @date：2019/3/12
 */
public class RedisTemplate {
    static {
        System.out.println("111");

    }

    public static void main(String[] args) {

        /*
        * 通过Resource获取BeanFactory
            加载Spring配置文件
            通过XmlBeanFactory+配置文件来创建IOC容器
        * */
//        //加载Spring的资源文件
//        Resource resource = new ClassPathResource("applicationContext.xml");
//
//        //创建IOC容器对象【IOC容器=工厂类+applicationContext.xml】
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        System.out.println(beanFactory.getBean("redisTemplate"));


        /*
        * 类路径下XML获取ApplicationContext
            直接通过ClassPathXmlApplicationContext对象来获取-->
            因为applicationContext文件在resource文件夹下，编译的路径直接位于classes下面，
            这个路径其实就是classPath的路径，
            所以，在resources 根目录下的配置文件其实就是 classPath的路径。
        * */
        // 得到IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ac.getBean("redisTemplate"));
    }


}
