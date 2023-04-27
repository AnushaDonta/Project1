package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.User;

public interface UserDao {
	User saveUser(User user);
	User getUserById(int uid);
	boolean deleteUserById(int uid);
	User updateUserById(int uid,User user);
	List<User> getAllUsers();
	List<User> getUsersByRole(String role);
}
