package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ClientExceptionMapper implements
		ExceptionMapper<ClientErrorException> {
	@Override
	public Response toResponse(ClientErrorException exception) {
		AdminServiceErrorCode errorCode = AdminServiceErrorCode.BAD_REQUEST;
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setBusinessException(errorCode.isBusinessException());
		errorResponse.setErrorCode(errorCode.name());
		errorResponse.setErrorDescription(errorCode.getErrorDescription());
		errorResponse.setSource(Source.CLIENT.name());
		return Response.status(Response.Status.BAD_REQUEST)
				.header("Content-Type", "application/json")
				.entity(errorResponse)
				.build();
	}

}
