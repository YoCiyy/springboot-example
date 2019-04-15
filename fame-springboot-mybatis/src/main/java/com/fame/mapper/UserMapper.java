package com.fame.mapper;

import com.fame.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}