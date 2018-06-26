package com.rrc.learnspring.Controller;

import com.rrc.learnspring.bean.User;
import com.rrc.learnspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addUser(){
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        return userService.add(user);
    }

    @RequestMapping("/get")
    public String getUser(){
        return userService.get(1);
    }
}