package com.fame.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Y.yang
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

	private static final long serialVersionUID = -6510879035056033993L;

	private Long id;

	private Integer age;

	private String password;

	private String username;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", age=" + age +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}