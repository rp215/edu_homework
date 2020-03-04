package lock.mysqllock;

import lock.redislock.RedisLock;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.util.SpringContextHolder;

/**
 * @author：renpeng
 * @date：2019/3/18
 */
public class TestDemo {

    @Test
    public void print(){
        // 加载ApplicationContext（模拟启动web服务）, 当然如果是用web工程的话,可以直接在web.xml配置，容器会去加载此文件。
        new ClassPathXmlApplicationContext("applicationContext.xml");

        RedisLock lock = (RedisLock) SpringContextHolder.getApplicationContext().getBean("redisLock");
        lock.print();
    }

}
