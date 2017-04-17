package com.mycomp.adminservice.rest.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.mycomp.adminservice.common.exceptions.ValidationErrorCode;
import com.mycomp.adminservice.common.exceptions.ValidationException;
import com.mycomp.adminservice.db.manager.dao.dto.User;

public class UserValidator extends AbstractValidator<User> {

	@Override
	public void validate(User query) throws ValidationException {
		contraintValidation(query);
		//lengthValidation(query);
	}
	

	private void contraintValidation(User query) throws ValidationException {
		StringBuilder constraintMessage = new StringBuilder("{");
		Set<ConstraintViolation<User>> violations = getVoilations(query);
		int count =0;
		for(ConstraintViolation<User> constraint : violations ) {
			constraintMessage.append(constraint.getPropertyPath().toString() + ":" + constraint.getMessage());
			count++;
			if(count < violations.size()) {
				constraintMessage.append(",");
			}
		}
		constraintMessage.append("}");
		if(violations.size() > 0) {
			throw new ValidationException(ValidationErrorCode.VALIDATION_CONSTRAINT, constraintMessage.toString());
		}	
	}

}
