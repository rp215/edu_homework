package com.edu.rp.concurrent.threadtype;

import java.util.concurrent.*;

/**
 * @功能描述：
 * @author
 */
public class CallableDemo implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo task = new CallableDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(task);

        System.out.println(future.get());

        executorService.shutdown();
    }

    @Override
    public Integer call() throws Exception {
        int a = 1;
        int b = 2;

        return a+b;
    }
}
