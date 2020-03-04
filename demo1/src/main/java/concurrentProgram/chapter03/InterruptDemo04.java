package concurrentProgram.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/3/1
 */
public class InterruptDemo04 {
    /*
    定义一个 volatile 修饰的成员变量，来控制线程的终止。这实际上是应用了
    volatile 能够实现多线程之间共享变量的可见性这一特点来实现的。
    * */
    private volatile static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i = 0;
            while (!flag){
                i++;
            }
            System.out.println(i);

        });
        thread.start();
        System.out.println("开启线程");
//        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        flag = true;
    }
}
