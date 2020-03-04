package lock.redislock;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import spring.util.SpringContextHolder;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author：renpeng
 * @date：2019/3/18
 */
@Component("redisLockImpl")
public class RedisLockImpl implements Lock {

    private static final String KEY = "key";

    private static final String LUA_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end ";

    private ThreadLocal<String> local = new ThreadLocal();//线程自身的本地存储，每个线程获取自己的内部变量

    //阻塞式加锁，一直加上锁为止
    @Override
    public void lock() {
        if (tryLock()){
            return;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock();//递归调用，重新加锁

    }
    //非阻塞式加锁，加一次就结束，不管加得上加不上
    @Override
    public boolean tryLock() {
        //产生随机值
        String uuid = UUID.randomUUID().toString();
        local.set(uuid);
        Jedis jedis = (Jedis) getFactory().getConnection().getNativeConnection();

        //保证写入值和设置失效时间是原子性的
        //使用setNx命令请求写值，并设置失效时间
        //向redis发起setnx命令写入，其中NX表示使用“nx”模式，“PX”表示失效时间的单位时毫秒
        String ret = jedis.set(KEY, uuid, "NX", "PX", 100);//使用setNx命令，判断KEY是否存在，不存在返回“OK”，并设置失效时间
        if ("OK".equals(ret)){
            return true;
        }
        return false;
    }
    //解锁
    @Override
    public void unlock() {
        //通过LUA脚本判断缓存是否存在，如果存在删除该key，保证获取数据，比较数据，删除数据是原子性的
        Jedis jedis = (Jedis) getFactory().getConnection().getNativeConnection();
        jedis.eval(LUA_LOCK, Arrays.asList(KEY), Arrays.asList(local.get()));
    }



    private JedisConnectionFactory getFactory(){
        //模拟web容器加载spring上下文，获取Jedis连接工厂
        JedisConnectionFactory factory = (JedisConnectionFactory) SpringContextHolder.getApplicationContext().getBean("jedisConncetionFactory");
        return factory;
    }




    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
