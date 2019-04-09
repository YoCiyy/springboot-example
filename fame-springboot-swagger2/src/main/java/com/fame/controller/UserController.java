package com.fame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fame.vo.UserVo;
import com.fame.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Swagger接口测试
 * 
 * @author Y.yang
 * @date 2019/3/12
 */
@Api(value = "用户信息", tags = { "用户信息" })
@RestController
public class UserController {

	@ApiOperation(value = "用户信息分页查询")
	@GetMapping("/page")
	public String page(User user) {
		return "Hello Swagger2";
	}

	@ApiOperation(value = "用户信息查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "file", value = "文件导入", required = true, dataType = "MultipartFile")
	})
	@GetMapping("/id")
	public UserVo getUser(Long id, MultipartFile file) {
		return new UserVo();
	}
}
