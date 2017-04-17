package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.ext.ExceptionMapper;


public abstract class BaseExceptionMapper<T extends BaseException> implements ExceptionMapper<T>{


	
	protected ErrorResponse getError(T exception) {
		//BaseException e1=(BaseException)e;
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(exception.getErrorCode());
		error.setBusinessException(exception.isBusinessException());
		error.setErrorDescription(exception.getErrorDescription());
		error.setSource(exception.getSource());

		return error;

	}

}
