package com.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "UserBroker")
@NamedQueries({
	@NamedQuery(name="findAll",
            query="SELECT u FROM User u WHERE u.userName = :userName")})

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(unique = true, nullable = false)
	private String password;

	public int getUserId() {
		return userId;
	}
	
	@SuppressWarnings("unused")
	private void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userName="
				+ userName + ", password=" + password + "]";
	}

}
