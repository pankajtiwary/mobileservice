package com.mycomp.adminservice.db.manager;

import java.util.List;

import com.mycomp.adminservice.db.manager.dao.dto.User;

public interface UserManager {
	
	public List<User> createUser(User user); 
	public User getUserById(String userId);
	public List<User> deleteUser(String userid);
	public List<User> getAllUsers();
	public List<User> updateUser(User user);
}
