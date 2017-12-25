package com.um.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.test.dao.UserDao;
import com.um.test.service.IUserService;
import com.um.test.vo.LyUser;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	public LyUser getUser(int id) {
		return userDao.getUser(id);
	}
}
