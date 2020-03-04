package concurrentProgram.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/3/1
 */
public class VisibleDemo {

    /*
    * 如果不设置volatile，在子线程中拿到flag的值，main主线程来改变这个值，而子线程拿不到，就会导致进程挂起
    这就是一个典型的可见性问题
    */
    private volatile static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 0;
            while (!flag){i++;}

        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        flag = true;

    }


}
