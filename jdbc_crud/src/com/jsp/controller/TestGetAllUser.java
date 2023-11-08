  package com.jsp.controller;

import java.security.Provider.Service;
import java.util.List;

import com.jsp.dto.User;
import com.jsp.service.UserService;

public class TestGetAllUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService service= new UserService();
		List<User> list = service.getAllUser();
		
		if(list.size()>0) {
			for(User user :list) {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getAge());
				System.out.println(user.getPhN());
			}
		}
		

	}

}
