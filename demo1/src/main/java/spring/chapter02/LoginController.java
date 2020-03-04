package spring.chapter02;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author：renpeng
 * @date：2019/3/14
 */
@Controller
public class LoginController {
    @Resource
//    @Autowired
    private LoginService loginService;

    public void print(){
        this.loginService.print();
        System.out.println("实例化LoginController");
    }
}
