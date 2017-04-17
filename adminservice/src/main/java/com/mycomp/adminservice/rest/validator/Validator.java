package com.mycomp.adminservice.rest.validator;

import com.mycomp.adminservice.common.exceptions.ValidationException;



public interface Validator<DATA> {
	
	public void validate(DATA data) throws ValidationException;
	

}
