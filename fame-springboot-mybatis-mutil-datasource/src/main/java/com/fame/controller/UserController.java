package com.fame.controller;

import com.fame.entity.Dept;
import com.fame.entity.User;
import com.fame.mapper.cluster.DeptMapper;
import com.fame.mapper.master.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Y.yang
 * @date 2019/4/24
 */
@RestController
@RequestMapping("/mutilDs")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    @GetMapping("/findAllUser")
    public User findAllUser(){
        return userMapper.selectByPrimaryKey(1);
    }

    @GetMapping("/findAllDept")
    public Dept findAllDept(){
        return deptMapper.selectByPrimaryKey(1);
    }
}
