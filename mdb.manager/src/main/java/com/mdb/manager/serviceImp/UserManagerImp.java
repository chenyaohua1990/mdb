package com.mdb.manager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdb.dao.UserDAO;
import com.mdb.manager.serviceI.UserManager;
import com.mdb.po.UserPO;
@Service
public class UserManagerImp implements UserManager{
	@Autowired
	private UserDAO userDAO;
	@Override
	public UserPO login(UserPO userQuery) {
		UserPO user=userDAO.findOne(userQuery);
		return user;
	}

}
