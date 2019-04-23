package com.fame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fame.entity.User;
import com.fame.mapper.UserMapper;
import com.fame.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Y.yang
 * @since 2019-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;

    /**
     * 用户信息查询全部
     *
     * @return 用户信息列表
     */
	@Override
	public List<User> findAll() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		return userMapper.selectList(queryWrapper);
	}

    /**
     * 用户信息新增
     */
	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

    /**
     * 用户信息修改
     */
	@Override
	public void updateByUser(User user) {
		userMapper.updateById(user);

	}

    /**
     * 用户信息删除
     */
	@Override
	public void deleteById(Long id) {
		userMapper.deleteById(id);
	}

}
