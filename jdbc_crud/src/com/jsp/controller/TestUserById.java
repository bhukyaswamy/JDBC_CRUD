  package com.jsp.controller;

import com.jsp.dto.User;
import com.jsp.service.UserService;

public class TestUserById {

	public static void main(String[] args) {
		UserService service = new UserService();
		User user = service.getuserById(1);

		if (user.getId()>0) {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getAge());
			System.out.println(user.getPhN());
		} else {
			System.out.println("Enter correct id; ");
		}

	}

}
