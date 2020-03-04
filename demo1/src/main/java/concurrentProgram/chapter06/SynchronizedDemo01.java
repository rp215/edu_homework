package concurrentProgram.chapter06;

/**
 * @author：renpeng
 * @date：2019/3/19
 */
public class SynchronizedDemo01 {

    private static int count = 1;

    private static Object lock = new Object();

    private static void add(){
        synchronized (lock){

        }
    }

    private synchronized static void incr() {
        count++;
    }

    private void incr1() {
        synchronized (lock) {
            count++;
        }
    }

    private void incr2() {
        synchronized (SynchronizedDemo01.class) {
            count++;
        }
    }

    /* 以上三种形式类似，锁的作用范围是全局的 */


    private void incr3() {
        synchronized (this) {
            count++;
        }
    }

    /* incr3() 锁是对象锁，如果是多个实例进行访问时，每个线程拿到的可能不是同一把锁，会导致数据修改出现问题 */



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                //全局锁的实现
//                    SynchronizedDemo01.incr();
//                    new SynchronizedDemo01().incr1();
                    new SynchronizedDemo01().incr2();

                //对象锁的实现
//                new SynchronizedDemo01().incr3();
            }).start();

        }

        Thread.currentThread().join(2);
        System.out.println(count);

        /*
        * 当一个线程视图访问带有synchronized修饰的同步代码块或者方法时，必须要先获得锁。
        * 当方法执行完毕退出以后或者出现异常的情况下会自动释放锁。
        * 因此锁的范围控制是由对象的作用域决定的，对象的作用域越大，那么锁的范围也就越大。
        * 所以我们可以得出一个结论，synchronized和对象有非常大的关系。
        *
        * */

    }


}
