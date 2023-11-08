package com.jsp.controller;

import com.jsp.dto.User;
import com.jsp.service.UserService;

public class TestSaveUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		UserService userService= new UserService();
		user.setId(11);
		user.setName("Sai");
		user.setAge(21);
		user.setPhN(333333333333l);
		int res=userService.saveData(user);
		if(res>0)
		System.out.println("data is saved");
		else 
			System.out.println("please check the object...");
			
	}

}
