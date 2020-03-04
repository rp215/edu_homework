package com.edu.rp.concurrent.threadpooldemo;

import com.edu.rp.util.SpringBeanUtil;
import org.springframework.stereotype.Component;

/**
 * @功能描述：
 */
@Component
public class HandleDemo implements Runnable{

    private static TestDemoImpl testDemo;

    @Override
    public void run() {
//        testDemo = (TestDemo) SpringBeanUtil.getBean("testDemo");
        testDemo = SpringBeanUtil.getBeanWithType(TestDemoImpl.class);
        System.out.println(testDemo);

        for (int i = 0; i < 10; i++) {
            System.out.print(Thread.currentThread().getName() + ":" + testDemo.print() + "<->");
            System.out.println(testDemo.print() + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
