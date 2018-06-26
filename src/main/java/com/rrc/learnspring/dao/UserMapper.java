package com.rrc.learnspring.dao;

import com.rrc.learnspring.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(user_name, password) values (#{userName},#{password})")
    int addUser(User user);

    List<User> selectUserById(int id);
}
