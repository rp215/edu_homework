package concurrentProgram.chapter01;

import java.util.concurrent.*;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class CallableTest {
    public static void main(String[] args) {
        //通过线程池的方式
        ExecutorService executorService = Executors.newCachedThreadPool();//创建线程池
        CallableDemo c1 = new CallableDemo();

        //第一种，通过Future和Callable
//        Future<Integer> f1 = executorService.submit(c1);

        //第二种，通过FutureTask和Callable
//        FutureTask<Integer> f1 = new FutureTask<Integer>(c1);
//        executorService.submit(f1);//提交当前这个线程到线程池中

        //第三种，通过Thread
        FutureTask<Integer> f1 = new FutureTask<Integer>(c1);
        Thread thread = new Thread(f1);
        thread.start();

        executorService.shutdown();// 关闭线程池
        try {
            int s = f1.get();//阻塞
            System.out.println(s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
