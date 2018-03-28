package com.sapient.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.User;


public interface UserDao {
	
	@Transactional
	public void addUser(User user);

	public User getUser(int userId);

	public List<User> getUserByName(String userName);

	

}
