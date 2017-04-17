package com.mycomp.adminservice.db.manager.dao.dto;


import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

public class User {
	
	@PathParam("firstName")
	@NotNull
	private String  userId; 
	

	@PathParam("firstName")
	@NotNull
	private String firstName; 
	
	@PathParam("lastName")
	@NotNull
	private String lastName;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
