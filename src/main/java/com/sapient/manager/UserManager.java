package com.sapient.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.UserDao;
import com.sapient.entity.User;

@Component
public class UserManager {
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public void setUser(User user) {
		userDao.addUser(user);
	}

	public Boolean validateUser(User user) {
		List<User> userList = new ArrayList<>();
		User userFromDB = null;
		userList = userDao.getUserByName(user.getUserName());
		if (userList.size()==1) {
			userFromDB = userList.get(0);
			if (userFromDB.getPassword().equals(user.getPassword())) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

}
