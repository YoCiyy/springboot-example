package com.fame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTemplate 测试
 *
 * @author Y.yang
 * @date 2019/5/14
 */
@RestController
public class UserController {

    /**
     * 操作k-v都是字符串的
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * k-v都是对象的
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/redis")
    public void redisJunit(){
        stringRedisTemplate.opsForValue().set("emp-01","emp-01");
        String s = stringRedisTemplate.opsForValue().get("emp-01");
        System.out.println(s);

    }
}
