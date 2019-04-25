package com.fame.mapper.cluster;

import org.apache.ibatis.annotations.Mapper;

import com.fame.entity.Dept;

@Mapper
public interface DeptMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Dept record);

	int insertSelective(Dept record);

	Dept selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dept record);

	int updateByPrimaryKey(Dept record);
}