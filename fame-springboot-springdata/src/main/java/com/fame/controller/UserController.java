package com.fame.controller;

import com.fame.entity.User;
import com.fame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息管理
 *
 * @author Y.yang
 * @date 2019/4/9
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;

	/**
	 * 用户信息新增
	 */
	@PostMapping("/add")
	@Transactional
	public void add() {
		User user = new User();
		// 对象链式编程，须在entity加入@Accessors(chain = true)
		user.setAge(22).setPassword("123");
		user = userRepo.save(user);

		System.out.println(user);
	}

	/**
	 * 用户信息修改
	 */
	@PostMapping("/update")
	@Transactional
	public void update() {
		User user = new User();
		user.setId(1L).setUsername("yy1");
		user = userRepo.save(user);
		System.out.println(user);
	}

	/**
	 * 用户信息删除
	 */
	@PostMapping("/delete")
	public void delete() {
		List<User> users = new ArrayList<User>();
		users.add(new User().setId(2L));
		users.add(new User().setId(3L));
		users.add(new User().setId(4L));
		userRepo.delete(users);
	}

	/**
	 * 用户信息查询
	 */
	@GetMapping("/get")
	public void get() {
		User user = userRepo.getOne(1L);
		System.out.println(user);
	}

	/**
	 * 继承 JpaSpecificationExecutor方法 自定义方法查询
	 */
	@GetMapping("/customizeQuery")
	public void customizeQuery() {
		System.out.println("通过用户名查询：" + userRepo.getByUsername("yy1"));
		System.out.println("通过用户名模糊查询（%?）：" + userRepo.findByUsernameStartingWith("yy2"));
		System.out.println("通过用户名模糊查询（?%）：" + userRepo.findByUsernameEndingWith("yy2"));
		System.out.println("通过ID查询，ID小于3的数据（<）" + userRepo.findByIdLessThan(3L));
	}

	/**
	 * 通过@Query方式，使用JPQL查询
	 */
	@GetMapping("/annotationQuery")
	public void annotationQuery() {
		System.out.println("通过@Query注解方法查询（最大ID数据）：" + userRepo.getMaxIdUser());
		System.out.println("通过@Query注解方法，传递参数占位符方式查询：" + userRepo.testQueryAnnotationUser1("yy2", 24));
		System.out.println("通过@Query注解方法，传递参数命名参数方式查询：" + userRepo.testQueryAnnotationUser2("yy1", 23));

	}

	/**
	 * 通过@Query @Modify方式，进行修改操作
	 */
	@PostMapping("/annotationUpdate")
	@Transactional
	public void annotationUpdate() {
		userRepo.updateUserAge(24);
	}

	/**
	 * 使用原生sql查询
	 */
	@GetMapping("/nativeQuery")
	public void nativeQuery() {
		System.out.println("设置 nativeQuery=true 开启原生sql查询：" + userRepo.getTotalCount());
	}

}
