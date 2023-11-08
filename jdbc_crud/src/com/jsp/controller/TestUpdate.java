package com.jsp.controller;

import java.security.Provider.Service;

import com.jsp.dto.User;
import com.jsp.service.UserService;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(1);
		user.setName("ravi");
		user.setAge(45);
		user.setPhN(8937393993l);
		
		UserService service = new UserService();
		int res =service.updateUser(user);
		
		if(res>0) {
			System.out.println("data is updated");
			
		}
		else 
			System.out.println("please check the object that you have given");

	}

}
