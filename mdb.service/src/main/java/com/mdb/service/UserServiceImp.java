package com.mdb.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.mdb.bean.User;
import com.ideal.mdb.serviceI.IUser;
import com.mdb.manager.serviceI.UserManager;
import com.mdb.po.UserPO;
@Service
public class UserServiceImp implements IUser {
	@Autowired
	private UserManager userManager;
	@Override
	public User login(User user) {
		UserPO userQuery=new UserPO();
		BeanUtils.copyProperties(user, userQuery);
		UserPO userPo= userManager.login(userQuery);
		BeanUtils.copyProperties(userPo, user);
		return user;
	}

	@Override
	public List<User> queryUserList(User user, int startPage, int pageSize) {
		 
		return null;
	}

}
