package com.mycomp.adminservice.common.exceptions;

import javax.ws.rs.core.Response;

public class AdminServiceExceptionMapper extends BaseExceptionMapper<AdminServiceException> {

	@Override
	public Response toResponse(AdminServiceException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.header("Content-Type", "application/json")
				.entity(getError(exception)).build();
	}

}
