package com.user.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Service.UserService;
import com.user.dao.UserDao;
import com.user.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override 
	public User getUser(String userCode, String password) {
		return userDao.getByPassword(userCode,password);
	}
	@Override
	public void insertTo(String userCode, String password) {
		userDao.insertTo(new Object[]{userCode,password,1});
		
	}
	@Override
	public boolean verfiCode(final String userCode) {
		Long count = userDao.verfiCode(userCode);
		System.out.println(count);
		if(count == 0) return true;
		else return false;
	}
	
}
