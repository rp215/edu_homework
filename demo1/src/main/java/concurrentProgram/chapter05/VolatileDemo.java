package concurrentProgram.chapter05;

/**
 * @author：renpeng
 * @date：2019/3/5
 */
public class VolatileDemo {
    private static volatile VolatileDemo volatileDemo = null;

    public static synchronized VolatileDemo getInstance(){
        if (volatileDemo == null){
            volatileDemo = new VolatileDemo();
        }
        return volatileDemo;
    }

    public static void main(String[] args) {
        VolatileDemo.getInstance();

    }
}
