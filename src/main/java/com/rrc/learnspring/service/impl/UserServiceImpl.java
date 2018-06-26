package com.rrc.learnspring.service.impl;

import com.alibaba.druid.support.json.JSONParser;
import com.rrc.learnspring.bean.User;
import com.rrc.learnspring.dao.UserMapper;
import com.rrc.learnspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String add(User user) {
        int i = userMapper.addUser(user);
        if (i > 0){
            return "Success";
        }else {
            return "Failure";
        }
    }

    @Override
    public String get(int id) {
        List<User> userList = userMapper.selectUserById(id);
        StringBuffer stringBuffer = new StringBuffer();
        for (User u : userList) {
            stringBuffer.append(u.getId()+"\t"+u.getUserName()+"\t"+u.getPassword()+"\n");
        }
        return stringBuffer.toString();
    }
}
