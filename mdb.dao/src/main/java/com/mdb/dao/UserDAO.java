package com.mdb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mdb.po.UserPO;

@Mapper
public interface UserDAO {
	
	UserPO findOne(@Param("user")UserPO userQuery);

}
