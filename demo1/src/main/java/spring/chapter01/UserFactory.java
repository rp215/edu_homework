package spring.chapter01;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
public class UserFactory {

    public final static UserServiceImpl getInstance(){
        return new UserServiceImpl();
    }
}
