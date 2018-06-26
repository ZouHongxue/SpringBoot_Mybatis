package com.rrc.learnspring.Controller;

import com.rrc.learnspring.bean.Mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

//    @Value("${mysql.url")
//    private String url;

    @Autowired
    Mysql mysql;

    @RequestMapping("/")
    public String index(){
        return mysql.getUrl()+"\t"+mysql.getName()+"\t"+mysql.getPassword();
    }
    @RequestMapping("/home")
    public String home(){
        return "Hello World";
    }
}
