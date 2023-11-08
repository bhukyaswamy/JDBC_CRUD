  package com.jsp.controller;

import com.jsp.dto.User;
import com.jsp.service.UserService;

public class TestDeleteUserById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService service = new UserService();
		User user = service.getuserById(1);

		if (user.getId()>0) {
			System.out.println("data is deleted");
			
		} else {
			System.out.println("Enter correct id; ");
		}

	}

}
