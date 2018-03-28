package com.sapient.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;


import com.sapient.dao.UserDao;

import com.sapient.entity.User;
import static org.junit.Assert.*;




public class TestUserManager{
	private static UserDao mockedUserDao = Mockito.mock(UserDao.class);
UserManager userManager = new UserManager();
@Before
public void setup(){
	userManager.setUserDao(mockedUserDao);
}

@Test
public void testGettingOfUsers(){
	User user1 = new  User("anjit oberoi", "aober2", "pass");
Mockito.when(mockedUserDao.getUser(1)).thenReturn(user1);
assertEquals(user1, userManager.getUser(1));

}

@Test
public void shouldTestValidationOfUser(){
	User user1 = new  User("anjit oberoi", "aober2", "pass");
	User user2 = new User("rati saxena", "rati", "pass1");
	User userFromDB = new User("anjit oberoi", "aober2", "pass");
	List<User> userList = new ArrayList<>();
	userList.add(userFromDB);
	Mockito.when(mockedUserDao.getUserByName(user1.getUserName())).thenReturn(userList);
	assertTrue(userManager.validateUser(user1));
	assertFalse(userManager.validateUser(user2));
	Mockito.verify(mockedUserDao).getUser(1);
	Mockito.verify(mockedUserDao).getUserByName(user1.getUserName());
	
}







}
