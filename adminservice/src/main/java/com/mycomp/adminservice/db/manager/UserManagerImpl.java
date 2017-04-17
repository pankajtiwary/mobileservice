package com.mycomp.adminservice.db.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mycomp.adminservice.common.exceptions.AdminServiceErrorCode;
import com.mycomp.adminservice.common.exceptions.AdminServiceException;
import com.mycomp.adminservice.db.manager.dao.dto.User;



public class UserManagerImpl implements UserManager {
	
	public static final Map<String,User> userCache = new HashMap<String,User>();
	
	static {
		User user = new User();
		user.setUserId("1");
		user.setFirstName("Bob");
		user.setLastName("Miller");
		userCache.put("1", user);
	}

	@Override
	public List<User> createUser(User user) {
		if(userCache.containsKey(user.getUserId())) {
			throw new AdminServiceException(AdminServiceErrorCode.USER_ALREADY_EXISTS, "");
		}
		
		userCache.put(user.getUserId(), user);
		return getAllUsers();
	}

	@Override
	public User getUserById(String userId) {
		if(userCache.containsKey(userId)) {
			return userCache.get(userId);
		}
		throw new AdminServiceException(AdminServiceErrorCode.USER_DOES_NOT_EXISTS, "");
	}

	@Override
	public List<User> deleteUser(String userId) {
		if(!userCache.containsKey(userId)) {
			throw new AdminServiceException(AdminServiceErrorCode.USER_DOES_NOT_EXISTS, "");
		}
		userCache.remove(userId);
		return getAllUsers();
	}

	@Override
	public List<User> getAllUsers() {
		Set<String> keys =  userCache.keySet();
		List<User> users = new ArrayList<User>();
		for(String userId : keys) {
			users.add(userCache.get(userId));
		}
		return users;
	}

	@Override
	public List<User> updateUser(User user) {
		if(!userCache.containsKey(user.getUserId())) {
			throw new AdminServiceException(AdminServiceErrorCode.USER_DOES_NOT_EXISTS, "");
		}
		userCache.remove(user.getUserId());
		userCache.put(user.getUserId(), user);
		return getAllUsers();
	}
	
	
}
