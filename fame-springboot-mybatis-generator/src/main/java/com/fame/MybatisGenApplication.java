package com.fame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Mybatis-generator启动类
 * 
 * @author Y.yang
 * @date 2019/4/16
 */
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.fame.mapper")
public class MybatisGenApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisGenApplication.class, args);
	}
}
