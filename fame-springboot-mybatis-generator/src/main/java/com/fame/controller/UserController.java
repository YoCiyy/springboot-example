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
		// where id = ?
		UserExample userEmp = new UserExample();
		userEmp.or().andIdEqualTo(userId);
		List<User> users1 = userMapper.selectByExample(userEmp);
		System.out.println(users1.get(0));

		userEmp.clear();
		// where ( id = ? and username =? ) or ( id = ? and age =? )
		userEmp.or().andIdEqualTo(userId).andUsernameEqualTo("大白1");
		userEmp.or().andIdEqualTo(userId).andAgeEqualTo(22);
		List<User> users2 = userMapper.selectByExample(userEmp);
		System.out.println(users2.get(0));
	}

	/**
	 * mybatis generator逆向工程 查询测试
	 *
	 * @param userId 用户ID
	 */
	@PutMapping("/update")
	public void update(Long userId) {
		User user = userMapper.selectByPrimaryKey(userId);

		// 通过ID 修改
		user.setUsername("大白generator 测试修改操作");
		// updateByPrimaryKey 全修改
		userMapper.updateByPrimaryKey(user);
		// updateByPrimaryKeySelective 选择user对象不为null 的修改
		userMapper.updateByPrimaryKeySelective(user);

		// 使用Example Criteria 通过关键字修改
		UserExample userEmp = new UserExample();
		userEmp.or().andIdEqualTo(userId);
		// updateByExample 全修改
		userMapper.updateByExample(user, userEmp);
		// updateByExampleSelective 选择user对象不为null 的修改
		userMapper.updateByExampleSelective(user, userEmp);

	}

	/**
	 * mybatis generator逆向工程 查询测试
	 *
	 * @param userId 用户ID
	 */
	@DeleteMapping("/delete")
	public void delete(Long userId) {

		// 通过ID 删除
		userMapper.deleteByPrimaryKey(userId);

		// 使用Example Criteria 通过关键字删除
		UserExample userEmp = new UserExample();
		userEmp.or().andIdEqualTo(userId);
		userMapper.deleteByExample(userEmp);
	}

	/**
	 * mybatis generator逆向工程 新增测试
	 *
	 * @param user 用户信息
	 */
	@PostMapping("/add")
	public void add(@RequestBody User user) {

		// 直接新增
		userMapper.insert(user);

		// 新增会做非空判断
		userMapper.insertSelective(user);
	}

	/**
	 * mybatis generator逆向工程 合计测试
	 */
	@GetMapping("/count")
	public void count(){

		// 查询全部数据
		long countAll = userMapper.countByExample(new UserExample());
		System.out.println(countAll);

		// 查询满足条件的数据
		UserExample userEmp = new UserExample();
		userEmp.or().andIdEqualTo(1L);
		long countByKey = userMapper.countByExample(userEmp);
		System.out.println(countByKey);
	}
}
