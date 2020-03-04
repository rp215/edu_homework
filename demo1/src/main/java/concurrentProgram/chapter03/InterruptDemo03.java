package concurrentProgram.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/3/1
 */
public class InterruptDemo03 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                try {
                    //注：interrupt()方法发出的中断信号只能被Object.wait()、Thread.sleep()、Thread.join()这三个方法捕捉到并产生中断
                    Thread.sleep(100000);
//                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                } catch (InterruptedException e) {
                    /*
                       抛出该异常，会清除中断标识，被动复位
                    */
//                    e.printStackTrace();
                }
            }

        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("after:"+thread.isInterrupted());
    }

}
