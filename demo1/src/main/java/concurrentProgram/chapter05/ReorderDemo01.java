package concurrentProgram.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @author：renpeng
 * @date：2019/3/6
 */
public class ReorderDemo01 {
    private static int a = 0;
    private static boolean flag = false;


    public static void main(String[] args){

        Thread threadA = new Thread(()->{
            a = 1; //线程A操作1
            flag = true; //线程A操作2

        });

        Thread threadB = new Thread(()->{
            if (flag){ //线程B操作3
                int i = a*a; //线程B操作4
                System.out.println("i:" + i);
            }

        });

        threadA.start();
        threadB.start();

    }
}
