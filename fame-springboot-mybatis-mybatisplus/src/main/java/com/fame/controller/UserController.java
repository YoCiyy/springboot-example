package com.fame.controller;

import com.fame.entity.User;
import com.fame.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Y.yang
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户信息查询全部
	 * 
	 * @return 用户信息列表
	 */
	@GetMapping("/list")
	public List<User> list() {
		return userService.findAll();
	}

	/**
	 * 用户信息新增
	 */
	@PostMapping("/add")
	public void add() {
		User user = new User().setUsername("mp insert").setPassword("123").setAge(24);
		userService.add(user);
	}

	/**
	 * 用户信息修改
	 */
	@PutMapping("/update")
	public void update() {
		User user = new User().setUsername("mp update").setPassword("123").setAge(24);
		userService.updateByUser(user);
	}

	/**
	 * 用户信息删除
	 */
	@DeleteMapping("/delete")
	public void delete() {
		userService.deleteById(1L);
	}
}
