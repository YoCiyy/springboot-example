package com.fame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybatis整合启动类
 * 
 * @author Y.yang
 * @date 2019/4/15
 */
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.fame.mapper")
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
