package concurrentProgram.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/2/28
 * 当其他线程通过调用当前线程的 interrupt 方法，表示向当前线程打个招呼，
 * 告诉他可以中断线程的执行了，至于什么时候中断，取决于当前线程自己。
 * 线程通过检查自身是否被中断来进行相应，可以通过 isInterrupted()来判断是 否被中断。
 * 这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源，
 * 而不是武断地将线程停止，因此这种终止线程的做法显得更加安全和优雅
 */
public class InterruptDemo01 {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("threadName:" + Thread.currentThread().getName());//主线程main
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(i);
            System.out.println("threadName:" + Thread.currentThread().getName());//Thread默认给thread1一个线程名——>"Thread-0"
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        //thread1并不会立即终止，一直等到查看thread1线程中断信号为true是才会终止
        thread.interrupt();//设置中断标志为true
        System.out.println("thread状态："+thread.isInterrupted());

    }
}
