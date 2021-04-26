package com.pojo;

import java.util.Date;
import java.util.List;

public class User {
	private String userName,password;
	private int userId; 
	

	public User(String userName, String password, int userId) {
		super();
		this.userName = userName;
		this.password = password;
		this.userId = userId;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(int userid) {
		super();
		this.userId = userid;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userId=" + userId + "]";
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



}
