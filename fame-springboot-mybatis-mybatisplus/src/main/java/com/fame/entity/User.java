package com.fame.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
// 开启链式编程
@Accessors(chain = true)
@ToString
public class User {
	private Long id;

	private Integer age;

	private String password;

	private String username;

}