package concurrentProgram.chapter05;

/**
 * @author：renpeng
 * @date：2019/3/6
 */
public class ReorderDemo02 {
    private static int b = 0;
    private static int a = 0;
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread01 = new Thread(()->{
            a=1;
            x=b;

        });

        Thread thread02 = new Thread(()->{
            b=1;
            y=a;

        });

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();

        System.out.println("x="+x+";y="+y);
        //不考虑编译器重排序和缓存可见性问题，执行结果可能是：x=0;y=1  x=1;y=0  x=1;y=1
        //重排序带也有带来在乱序执行，其可能输出x=0;y=0
    }
}
