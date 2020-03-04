package concurrentProgram.chapter01;

import java.util.concurrent.Callable;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class CallableDemo implements Callable {
    @Override
    public Integer call() throws Exception {
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = i++;
        }
        return num;
    }
}
