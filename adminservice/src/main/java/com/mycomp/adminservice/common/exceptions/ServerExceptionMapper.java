package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;


public class ServerExceptionMapper implements
		ExceptionMapper<ServerErrorException> {
	Logger logger = Logger.getLogger(ServerExceptionMapper.class);

 @Override
	public Response toResponse(ServerErrorException exception) {
	 	logger.error(exception.getMessage());
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setBusinessException(false);
	    errorResponse.setErrorCode("INTERNAL_SERVER_ERROR");
	    errorResponse.setErrorDescription("Internal Server Error while processing request ");
	    errorResponse.setSource(Source.ADMINSERVICE.name());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.header("Content-Type", "application/json")
				.entity(errorResponse).build();
	}

}
