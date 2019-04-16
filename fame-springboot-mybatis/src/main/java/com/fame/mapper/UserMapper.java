package com.fame.mapper;

import com.fame.entity.User;

import java.util.List;

/**
 * mapper 接口
 * 
 * @author Y.yang
 */
public interface UserMapper {

	/**
	 * 用户列表查询
	 * 
	 * @return 用户信息列表
	 */
	List<User> findAll();

	/**
	 * 新增用户信息
	 * 
	 * @param user 用户信息
	 */
	void add(User user);

	/**
	 * 通过ID获取用户信息
	 * 
	 * @param id 用户ID
	 * @return 用户信息
	 */
	User get(Long id);

	/**
	 * 修改用户信息
	 *
	 * @param user 用户信息
	 */
	void update(User user);

	/**
	 * 删除用户信息
	 * 
	 * @param id 用户ID
	 */
	void delete(long id);
}