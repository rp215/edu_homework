package lock.jdklock;

import lock.redislock.RedisLockImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.util.SpringContextHolder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：renpeng
 * @date：2019/3/18
 */
public class LockImpl {

    private static int count = 100;
    //jdk提供的锁
//    private Lock lock = new ReentrantLock();

    //通过redis实现的分布式锁
    private RedisLockImpl lock;


    @Test
    public void doTest() throws InterruptedException {
        new ClassPathXmlApplicationContext("applicationContext.xml");//模拟启动web服务，加载applicationContext.xml文件
        RedisLockImpl redisLock = (RedisLockImpl) SpringContextHolder.getApplicationContext().getBean("redisLockImpl");

        LockImpl lock = new LockImpl();
        this.lock = redisLock;

        Sell sell = new Sell();

        Thread t1 = new Thread(sell, "窗口1");
        Thread t2 = new Thread(sell, "窗口2");
        Thread t3 = new Thread(sell, "窗口3");
        Thread t4 = new Thread(sell, "窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.currentThread().join();
    }

    private class Sell implements Runnable{

        @Override
        public void run() {
            while(count > 0){
                /*
                 * lock 比synchronized更加灵活
                 * 缺点是：jvm锁只能解决（应用内部的问题）单进程里面的多线程共享资源任务，解决不了分布式环境下的多任务对共享资源的竞争操作问题，
                 * */
                // lock.lockInterruptibly(); ——可中断式加锁，加锁一段时间，加不上久放弃
                // lock.tryLock(); ——加一次锁，加不上就放弃
                // lock.tryLock(long timeout, TimeUnit unit);
                lock.lock();//阻塞式加锁，一定到加上为止，类似于synchronized
                try {
                    if (count > 0){
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + (count--) + "票");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
