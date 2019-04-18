package com.fame.controller;

import com.fame.entity.User;
import com.fame.entity.UserExample;
import com.fame.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Y.yang
 * @date 2019/4/16
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	/**
	 * mybatis generator逆向工程 查询测试
	 * 
	 * @param userId 用户ID
	 */
	@GetMapping("/get")
	public void get(Long userId) {

		// 通过主键ID 获取用户信息
		User user = userMapper.selectByPrimaryKey(userId);
		System.out.println(user);

		// 通过example Criteria 查询
		UserExample userEmp = new UserExample();
		userEmp.or().andIdEqualTo(userId);
		List<User> users = userMapper.selectByExample(userEmp);
		System.out.println(users.get(0));
	}

    /**
     * mybatis generator逆向工程 查询测试
     *
     * @param userId 用户ID
     */
	@PutMapping("/update")
	public void update(Long userId) {

		User user = userMapper.selectByPrimaryKey(userId);
		user.setUsername("大白generator 测试修改操作");
		userMapper.updateByPrimaryKeySelective(user);
	}

    /**
     * mybatis generator逆向工程 查询测试
     *
     * @param userId 用户ID
     */
	@DeleteMapping("/delete")
	public void delete(Long userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

    /**
     * mybatis generator逆向工程 新增测试
     *
     * @param user 用户信息
     */
	@PostMapping("/add")
	public void add(@RequestBody User user) {
		userMapper.insert(user);
	}
}
