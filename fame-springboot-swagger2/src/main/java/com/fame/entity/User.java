package com.fame.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息 数据传输对象 Dto（Data Transfer Object）
 * 
 * @author Y.yang
 * @date 2019/3/29
 */
@Data
@ApiModel(description = "用户信息请求对象")
public class User implements Serializable {

	private static final long serialVersionUID = -6986638131456347054L;

	@ApiModelProperty(value = "姓名")
	private String username;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄")
	private Integer age;

}
