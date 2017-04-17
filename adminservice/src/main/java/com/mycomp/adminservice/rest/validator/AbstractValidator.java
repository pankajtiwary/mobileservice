package com.mycomp.adminservice.rest.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public abstract class AbstractValidator<DATA> implements Validator<DATA> {
	
	
	protected Set<ConstraintViolation<DATA>> getVoilations(DATA data) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator  validator = factory.getValidator();
		Set<ConstraintViolation<DATA>> violations = validator.validate(data);
		return violations;
	}

}
