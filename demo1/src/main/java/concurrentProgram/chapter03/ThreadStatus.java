package concurrentProgram.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class ThreadStatus {
    public static void main(String[] args) {

        new Thread(()->{
            while (true){

                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();


        new Thread(()->{
            while (true){
                synchronized (ThreadStatus.class){
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"waitting").start();

        new Thread(new BlockedDemo(),"BlockedDemo-01").start();
        new Thread(new BlockedDemo(),"BlockedDemo-02").start();
    }


    static class BlockedDemo extends Thread{
        @Override
        public void run() {

            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }
}
