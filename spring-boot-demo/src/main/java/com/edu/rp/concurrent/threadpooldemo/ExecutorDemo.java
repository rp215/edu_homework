package com.edu.rp.concurrent.threadpooldemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @功能描述：
 */
@RestController
public class ExecutorDemo {

    @GetMapping("/handleTest")
    public void print() {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("Thread-rp-%d").build();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                5000,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1),
                factory,
                new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(new HandleDemo());

        executorService.shutdown();
    }

}
