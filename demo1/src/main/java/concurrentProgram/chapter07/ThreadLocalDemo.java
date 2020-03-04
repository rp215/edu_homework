package concurrentProgram.chapter07;

import org.junit.Test;

import java.util.UUID;

/**
 * @author：renpeng
 * @date：2019/4/1
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    @Test
    public void doTest() throws InterruptedException {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Modify modify = threadLocalDemo.new Modify();

        Thread thread1 = new Thread(modify);
        Thread thread2 = new Thread(modify);
        Thread thread3 = new Thread(modify);
        Thread thread4 = new Thread(modify);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.currentThread().join();
    }


     class Modify extends Thread{

        @Override
        public void run() {
            String uuid = UUID.randomUUID().toString();
            System.out.println("当前线程"+ Thread.currentThread().getName()+"开始设值：" + uuid);
            local.set(uuid);
            System.out.println("获取当前线程"+ Thread.currentThread().getName() +"中的局部变量id：" + local.get());
        }
    }
}
