package com.edu.rp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @功能描述：
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {
    private static ApplicationContext appCon;

    /**
     * 只有在当前正在实例化的类是Aware类型时，且是ApplicationContextAware类型时才会调用到
     * setApplicationContext(this.applicationContext)方法把spring应用上下文设置进去。
     * 即：实现了ApplicationContextAware接口的类
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.appCon = applicationContext;
    }

    public static Object getBean(String beanName) {
        return appCon.getBean(beanName);
    }

    public static <T> T getBeanWithType(Class<T> clazz) {
        return (T)appCon.getBean(clazz);
    }
}
