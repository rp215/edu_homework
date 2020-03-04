package lock.jdklock;


import lock.redislock.RedisLock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：renpeng
 * @date：2019/3/7
 * 线程不安全的原因：多线程环境下对共享内存（类变量、静态变量）中数据的操作存在可见性问题；
 */
@Component
public class JdkLock {
    private static int count = 100;//1.7之前方法区；1.8以后元空间
    //jdk自带的锁
//    private Lock lock = new ReentrantLock();

    @Resource(name = "redisLock")
    private RedisLock lock;
//    private Lock lock = new RedisLock();


    @Test
    public void ticketTest() throws InterruptedException {
        DoTest doTest = new DoTest();
        Thread thread01 = new Thread(doTest,"窗口1");
        Thread thread02 = new Thread(doTest,"窗口2");
        Thread thread03 = new Thread(doTest,"窗口3");
        Thread thread04 = new Thread(doTest,"窗口4");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();

        Thread.currentThread().join();
    }

    private class DoTest implements Runnable{

        @Override
        public void run() {
            while (count > 0){
                /*
                * lock 比synchronized更加灵活
                * 缺点是：jvm锁只能解决（应用内部的问题）单进程里面的多线程共享资源任务，解决不了分布式环境下的多任务对共享资源的竞争操作问题，
                * */
                // lock.lockInterruptibly(); ——>可中断式加锁，加锁一段时间，加不上久放弃
                // lock.tryLock(); ——>加一次锁，加不上就放弃
                // lock.tryLock(long timeout, TimeUnit unit);
                lock.lock();//阻塞式加锁，一定到加上为止，类似于synchronized
                try {
                    if (count > 0){
                        System.out.println(Thread.currentThread().getName() + "售出第" + (count--)+ "张票");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    // finally最终都会执行，避免因为一些处理逻辑出现问题而抛出异常，导致的死锁
                    lock.unlock();//解锁
                }


                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
