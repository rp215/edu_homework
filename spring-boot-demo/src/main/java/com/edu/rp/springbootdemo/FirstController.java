package com.edu.rp.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renpeng
 */

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String say() {
        return "say:hello world";
    }

    @GetMapping("/print")
    public void print() {
        List<User> list = new ArrayList();
        while (true) {
            list.add(new User());
        }
    }
}
