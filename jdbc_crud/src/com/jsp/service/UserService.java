package com.jsp.service;

import java.util.List;

import com.jsp.dao.UserDao;
import com.jsp.dto.User;

public class UserService {
	UserDao userdao= new UserDao();
	public void createTable() {
		userdao.createTable();
	}
	public int saveData(User user) {
		return userdao.saveData(user);
		
	}
	public List<User> getAllUser(){
		return userdao.getAllUser();
	
	}
	public User getuserById(int id){
		return userdao.getuserById(id);
	
	}

	public int updateUser(User user) {
		return userdao.updateUser(user);
	}
	public int deleteUser(int id) {
		return userdao.deleteUser(id);
	}
}
