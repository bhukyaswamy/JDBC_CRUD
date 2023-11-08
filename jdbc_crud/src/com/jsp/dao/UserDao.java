package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.User;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.PreparableStatement;

public class UserDao {
	public void createTable() {
		// steps for create table....
		try {
			DriverManager.registerDriver(new Driver());

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root",
					"root");

			Statement statement = connection.createStatement();

			statement.executeUpdate("create table user(id int primary key,name varchar(45),age int,phon bigint(10))");

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int saveData(User user) {
		try {
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root",
					"root");

			PreparedStatement prepareStatement = connection.prepareStatement("insert into user values(?,?,?,?)");
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setLong(4, user.getPhN());

			int res = prepareStatement.executeUpdate();
			connection.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}  
	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();

		try {
			DriverManager.registerDriver(new Driver());

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root",
					"root");

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select *from user");

			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3));
				user.setPhN(resultSet.getLong(4));

				list.add(user);

			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public User getuserById(int id) {
		User user = new User();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root",
					"root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id=?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3)); 
				user.setPhN(resultSet.getLong(4));

			}
			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public int updateUser(User user) {
		try {
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("update user set name=?,age=?,phon=? where id=?");
			preparedStatement.setString(1,user.getName());
			preparedStatement.setInt(2,user.getAge());
			preparedStatement.setLong(3,user.getPhN());
			preparedStatement.setInt(4,user.getId());
			
			int res =preparedStatement.executeUpdate();
			
			connection.close();
			
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteUser(int id) {
		try {
			DriverManager.registerDriver(new Driver());
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_geam4", "root","root");
			PreparedStatement preparedStatement =connection.prepareStatement("delete from user where id=?");
			preparedStatement.setInt(1, id);
			
			int res =preparedStatement.executeUpdate();
			connection.close();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

