package com.fame.controller;

import com.fame.entity.User;
import com.fame.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Y.yang
 * @date 2019/4/14
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询用户列表
	 */
	@GetMapping("/list")
	public List<User> list() {
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
		return userList;
	}

	/**
	 * 通过ID获取用户信息
	 */
	@GetMapping("/get")
	public User get() {
		return userMapper.get(8L);
	}

	/**
	 * 新增用户信息
	 */
	@PostMapping("/add")
	public void add() {
		User user = new User().setUsername("大白一号").setPassword("dabaiyihao").setAge(22);
		userMapper.add(user);
	}

	/**
	 * 修改用户信息
	 */
	@PutMapping("/update")
	public void update() {
		User user = userMapper.get(1L);
		user.setUsername("大白修改操作");
		userMapper.update(user);
	}

    /**
     * 删除用户信息
     */
    @DeleteMapping("/delete")
	public void delete() {
	    userMapper.delete(9L);
	}

}
