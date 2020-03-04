package concurrentProgram.chapter05;

/**
 * @author：renpeng
 * @date：2019/3/6
 */
public class AtomicityDemo {
    volatile int i;//加上volatile关键字后，在编译后的字节码中，i变量会多了一个flag——ACC_VOLATILE

    public void incr(){
        i++;
    }

    public static void main(String[] args) {
        new AtomicityDemo().incr();

    }
}
