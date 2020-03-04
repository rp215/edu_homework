package spring.chapter01;

import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @author：renpeng
 * @date：2019/3/14
 */

public class UserController {

    private UserServiceImpl userService;

    //构造注入
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }

    //set注入
//    public void setUserService(UserServiceImpl userService) {
//        this.userService = userService;
//    }


    //工厂方法注入
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


    public void sys(){
        this.userService.print();
    }
}
