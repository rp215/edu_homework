package spring.chapter02;

import org.springframework.stereotype.Repository;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
@Repository
public class LoginDaoImpl implements LoginDao{
    @Override
    public void print() {
        System.out.println("实例化LoginDao");
    }
}
