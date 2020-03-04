package spring.util;

import org.apache.commons.lang.Validate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author：renpeng
 * @date：2019/3/18
 * 在Web应用中，Spring容器通常采用声明式方式配置产生：只需要在web.xml中配置一个Listener，该Listener将会负责初始化Spring容器，
 * MVC框架可以直接调用Spring容器中的Bean，无需访问Spring容器本身。
 * 在这种情况下，容器中的Bean处于容器管理下，无需主动访问容器，只需接受容器的依赖注入即可。
 *
 * 但在某些特殊的情况下，Bean需要实现某个功能，但该功能必须借助于Spring容器才能实现，
 * 此时就必须让该Bean先获取Spring容器，然后借助于Spring容器实现该功能。
 * 为了让Bean获取它所在的Spring容器，可以让该Bean实现ApplicationContextAware接口。
 * 其他类可以通过引用SpringContextHolder来操作spring容器及其中的Bean实例，
 * Spring 提供了ApplicationContextAware类，通过它可以获取所有bean上下文。
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 注入spring的applicationContext到静态变量中
     * Spring容器会检测容器中的所有Bean，如果发现某个Bean实现了ApplicationContextAware接口，
     * Spring容器会在创建该Bean之后(在配置文件中配置该Bean)，自动调用该Bean的setApplicationContext()方法，
     * 调用该方法时，会将容器本身作为参数传给该方法——该方法中的实现部分将Spring传入的参数（容器本身）赋给该类的applicationContext静态变量，
     * 因此接下来可以通过该applicationContext静态变量来访问容器本身。
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;//传入的applicationContext是Spring容器本身
    }

    /**
     * 获取静态变量中的ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取Bean
     * @param beanName
     * @return
     */
    public Object getBeanByName(String beanName){
        return applicationContext.getBean(beanName);
    }


}
