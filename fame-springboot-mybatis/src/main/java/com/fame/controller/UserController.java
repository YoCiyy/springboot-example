package com.fame.controller;

import com.fame.entity.User;
import com.fame.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Y.yang
 * @date 2019/4/14
 */
@RequestMapping("/user")
@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public void list(){
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

}

