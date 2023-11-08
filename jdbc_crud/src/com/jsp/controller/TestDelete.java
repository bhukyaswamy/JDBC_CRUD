package com.jsp.controller;

import com.jsp.service.UserService;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService service = new UserService();
		int res=service.deleteUser(1);
	if(res>0) {
		System.out.println("Data is deleted");
	}
	else 
		System.out.println("please check the id");

	}

}
