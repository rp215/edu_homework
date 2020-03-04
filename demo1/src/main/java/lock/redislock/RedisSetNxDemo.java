package lock.redislock;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.net.URL;

/**
 * @author：renpeng
 * @date：2019/3/7
 */
public class RedisSetNxDemo {

    @Test
    public void doTest() {

        Jedis jedis = new Jedis("localhost");
        String ret = jedis.set("rp", "666", "NX", "PX", 1000000);
        System.out.println(ret);
        jedis.close();
    }


}
