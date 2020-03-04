package lock.redislock;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import spring.util.SpringContextHolder;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author：renpeng
 * @date：2019/3/7
 */
@Component
public class RedisLock implements Lock {

    //lua脚本，在解锁的时候保证获取数据、比较数据一致、删除数据是原子性的
    private static final String SCRIPT_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end ";
    //设置缓存key
    private static final String KEY = "key";

//    @Resource(name = "jedisConncetionFactory")
//    private JedisConnectionFactory factory;

    //ThreadLocal，很多地方叫做线程本地变量，也有些地方叫做线程本地存储，其实意思差不多。
    //ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
    private ThreadLocal<String> local = new ThreadLocal<String>();

    /**
     * 获取Jedis链接工厂
     * @return
     */
    private JedisConnectionFactory getFactory(){
        //模拟web容器加载spring上下文，获取Jedis连接工厂
        JedisConnectionFactory factory = (JedisConnectionFactory) SpringContextHolder.getApplicationContext().getBean("jedisConncetionFactory");
        return factory;
    }

    @Override
    public void lock() {
        //1、尝试加锁
        if (tryLock()) {
            return;
        }

        //2、加锁失败，当前任务休眠一段时间
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //3、递归调用，再次重新加锁
        lock();

    }


    //非阻塞式加锁，使用setNx命令返回ok的加锁成功，并把随机值写入ThreadLocal
    @Override
    public boolean tryLock() {
        //产生随机值
        String uuid = UUID.randomUUID().toString();
        local.set(uuid);
        //获取redis的连接
        Jedis jedis = (Jedis) getFactory().getConnection().getNativeConnection();
//        Jedis jedis = (Jedis) factory.getConnection().getNativeConnection();


        //使用setNx命令请求写值，并设置失效时间
        //向redis发起setnx命令写入，其中NX表示使用“nx”模式，“PX”表示失效时间的单位时毫秒
        String ret = jedis.set(KEY, uuid, "NX", "PX", 50);
        //返回“OK”意味着加锁成功
        if ("OK".equals(ret)) {
            return true;
        }
        //不是返回“OK”意味着加锁失败
        return false;
    }


    //解锁
    @Override
    public void unlock() {
        //读取lub脚本
//        String script = SCRIPT_LOCK;
        //获取redis的连接
        Jedis jedis = (Jedis) getFactory().getConnection().getNativeConnection();
        /*
        * 解锁将每个线程（ThreadLocal）对应的的值与redis上的key的值进行对比，如果相同的话就可以进行删除
        * */
        //通过原始连接链接redis执行lua脚本
        /*
        * SCRIPT_LOCK——脚本程序
        * Arrays.asList(KEY)——在脚本中所用到的那些 Redis 键(key)，这些键名参数可以在 Lua 中通过全局变量 KEYS 数组，
        * 用 1 为基址的形式访问( KEYS[1] ， KEYS[2] ，以此类推)。
        * Arrays.asList(local.get())——在 Lua 中通过全局变量 ARGV 数组访问，访问的形式和 KEYS 变量类似( ARGV[1] 、 ARGV[2] ，诸如此类)。
        * */

        /*
        * Arrays.asList的作用是将数组转化为list，一般是用于在初始化的时候，设置几个值进去，简化代码，省去add的部分。
        * 不支持add和remove，如果不需要改变长度可以使用Arrays.asList()。
        * 该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean），可以是integer。
        * */
        jedis.eval(SCRIPT_LOCK, Arrays.asList(KEY), Arrays.asList(local.get()));

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }


    public void print(){
        System.out.println("RedisLock实例注入开始");
    }
}
