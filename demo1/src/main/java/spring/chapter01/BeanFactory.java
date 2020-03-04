package spring.chapter01;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class BeanFactory {
    public BeanFactory() {
        System.out.println("User实例化中");
    }

    public User getInstance(){
        return new User();
    }
}
