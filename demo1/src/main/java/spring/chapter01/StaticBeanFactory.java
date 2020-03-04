package spring.chapter01;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class StaticBeanFactory {
    public static User getInstance(){
        System.out.println("User实例化开始");
        return new User();
    }
}
