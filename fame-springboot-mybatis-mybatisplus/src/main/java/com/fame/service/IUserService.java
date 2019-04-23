package com.fame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fame.entity.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Y.yang
 * @since 2019-04-22
 */
public interface IUserService extends IService<User> {

    /**
     * 用户信息查询全部
     *
     * @return 用户信息列表
     */
	List<User> findAll();

    /**
     * 用户信息新增
     */
	void add(User user);

    /**
     * 用户信息修改
     */
	void updateByUser(User user);

    /**
     * 用户信息删除
     */
	void deleteById(Long id);

}
