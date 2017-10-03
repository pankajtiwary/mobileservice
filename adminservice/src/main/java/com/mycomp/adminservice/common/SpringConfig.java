package com.mycomp.adminservice.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mycomp.adminservice.db.manager.UserManager;
import com.mycomp.adminservice.db.manager.UserManagerImpl;
import com.mycomp.adminservice.db.manager.dao.dto.User;
import com.mycomp.adminservice.rest.validator.AbstractValidator;
import com.mycomp.adminservice.rest.validator.UserValidator;
import com.mycomp.adminservice.rest.validator.Validator;
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {

	@Bean
	public UserManager userManager() {
		return new UserManagerImpl();
	}
	

	@Bean
	public Validator<User> userValidator() {
		return new UserValidator();
	}
	

	
	
}
