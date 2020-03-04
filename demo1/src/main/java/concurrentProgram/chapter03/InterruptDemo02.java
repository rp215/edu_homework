package concurrentProgram.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/3/1
 */
public class InterruptDemo02 {

    //Thread.interrupted()对设置中断标识的线程复位
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (true){
                // isInterrupted()——>获取调用该方法的对象所表示的线程的中断状态是什么（意味着查看中断标识为true/false/），默认是false
                boolean flag = Thread.currentThread().isInterrupted();//（中断标识为true）
                if (flag) {
                    System.out.println("before:" +flag);
                    /*
                    interrupted获取当前线程的中断状态，并且会清除线程的状态标识，是一个静态方法，这里的当前线程就是调用该方法的线程——>main
                    疑问：为什么第二次调用isInterrupted方法会返回false呢？这里并没有对thread线程进行复位？
                    原因是：调用interrupted()方法会清除线程的中断标识(可以理解为唤醒线程，让线程继续执行)，底层调用了isInterrupted(true)(中断
                    状态将会根据传入的ClearInterrupted参数值来确定是否重置，true的话表示清除中断状态)。
                    在第一次调用isInterrupted()时，由于此前执行了thread.interrupt();，导致thread线程被标识了一个中断标识，因此第一次调用
                    isInterrupted()会返回true。由于interrupted()具有清除中断标识的的功能，因此第二次调用isInterrupted()方法会返回false
                    */

                    //对线程设置了中断标识之后进行复位(这里把调用interrupt设置的中断标识就变成了——>false，从而让中断标识没有作用)
                    Thread.interrupted();
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }

            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //注：interrupt()方法发出的中断信号只能被Object.wait()、Thread.sleep()、Thread.join()这三个方法捕捉到并产生中断
        thread.interrupt();//将调用该方法所表示的线程，设置一个中断状态(true)
        System.out.println("中断标识设置后，线程状态："+thread.isAlive());
    }
}
