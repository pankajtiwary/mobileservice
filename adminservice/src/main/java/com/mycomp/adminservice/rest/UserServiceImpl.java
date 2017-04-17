package com.mycomp.adminservice.rest;



import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycomp.adminservice.common.exceptions.AdminServiceErrorCode;
import com.mycomp.adminservice.common.exceptions.AdminServiceException;
import com.mycomp.adminservice.common.exceptions.ValidationException;
import com.mycomp.adminservice.db.manager.UserManager;
import com.mycomp.adminservice.db.manager.dao.dto.User;
import com.mycomp.adminservice.rest.validator.Validator;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserManager userManager;

	@Autowired
	Validator<User> userValidator;
	
	@Override
	public Response getAllUsers() throws ValidationException,
			AdminServiceException {
		return Response.status(Response.Status.OK).header("Content-Type", "application/json").entity(userManager.getAllUsers()).build();
	}

	@Override
	public Response createUser(User user) throws ValidationException,
			AdminServiceException {
		userValidator.validate(user);
		List<User> users = userManager.createUser(user);
		return Response.status(Response.Status.OK).header("Content-Type", "application/json").entity(users).build();
		
	}

	@Override
	public Response getUser(String userid) throws ValidationException,
			AdminServiceException {
		checkUserId(userid);
		User user = userManager.getUserById(userid);
		return Response.status(Response.Status.OK).header("Content-Type", "application/json").entity(user).build();
	}

	@Override
	public Response deleteUser(String userid) throws ValidationException,
			AdminServiceException {
		checkUserId(userid);
		List<User> users = userManager.deleteUser(userid);
		return Response.status(Response.Status.OK).header("Content-Type", "application/json").entity(users).build();
	}

	@Override
	public Response updateUser(User user) throws ValidationException,
			AdminServiceException {
		userValidator.validate(user);
		List<User> users = userManager.updateUser(user);
		return Response.status(Response.Status.OK).header("Content-Type", "application/json").entity(users).build();
	}
	
	private void checkUserId(String userId) throws AdminServiceException{
		if(userId == null || userId.length() == 0 || userId.trim().length() == 0) {
			throw new AdminServiceException(AdminServiceErrorCode.USER_ID_CANT_BE_NULL, "");
		}
		
	}
	
}
