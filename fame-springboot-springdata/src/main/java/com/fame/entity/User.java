package com.fame.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Y.yang
 */
@Entity
@Data
/*开启lombok链式编程*/
@Accessors(chain = true)
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "sys_user")
public class User implements Serializable{

	private static final long serialVersionUID = 6425411731900579688L;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "bigint(20) comment '主键'", nullable = false)
	private long id;

	@Column(columnDefinition = "varchar(255) comment '用户姓名'",nullable = false, unique = true)
	private String username;

	@Column(columnDefinition = "varchar(255) comment '密码'", nullable = false)
	private String password;

	@Column(columnDefinition = "int(10) comment '年龄'", nullable = false)
	private int age;

}
