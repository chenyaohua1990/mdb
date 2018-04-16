package com.mdb.dao;

import org.springframework.stereotype.Repository;

import com.mdb.po.UserPO;
@Repository
public interface UserDAO {
	
	UserPO findOne(UserPO userQuery);

}
