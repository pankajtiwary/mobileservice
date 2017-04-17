package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.core.Response;

public class ValidationExceptionMapper extends BaseExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException exception) {
		
		return Response.status(Response.Status.PARTIAL_CONTENT)
				.header("Content-Type", "application/json")
				.entity(getError(exception)).build();
	}

}
