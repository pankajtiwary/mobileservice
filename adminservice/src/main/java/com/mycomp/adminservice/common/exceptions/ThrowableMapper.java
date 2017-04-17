package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

public class ThrowableMapper implements ExceptionMapper<Throwable> {

	Logger logger = Logger.getLogger(ThrowableMapper.class);
	@Override
	public Response toResponse(Throwable throwable) {
		logger.error(throwable.getMessage());
		AdminServiceErrorCode errorCode = AdminServiceErrorCode.INTERNAL_SERVER_ERROR;
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setBusinessException(errorCode.isBusinessException());
		errorResponse.setErrorCode(errorCode.name());
		errorResponse.setErrorDescription(errorCode.getErrorDescription());
		errorResponse.setSource(Source.ADMINSERVICE.name());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.header("Content-Type", "application/json")
				.entity(errorResponse)
				.build();
	}

}
