package spring.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Resource
//    @Autowired
    private LoginDao loginDao;

    @Override
    public void print() {
        this.loginDao.print();
        System.out.println("实例化LoginServiceImpl");
    }
}
