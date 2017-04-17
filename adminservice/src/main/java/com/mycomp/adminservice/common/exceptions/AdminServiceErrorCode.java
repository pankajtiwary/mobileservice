package com.mycomp.adminservice.common.exceptions;

public enum AdminServiceErrorCode {
	OPERATION_NOT_SUPPORTED("Operation Not Supported for this method",false),
	BAD_REQUEST("Bad Request, Pls check the request and send again ",false),
	INTERNAL_SERVER_ERROR("Exception while processing the request ", false),
	NO_MATCHING_RESULT_FOUND("No Matching Result Found ", true),
	UNABLE_TO_INSERT_RECORD("Unable to Insert Record ", true),
	UNABLE_TO_UPDATE_RECORD("Unable to Update Record ", true),
	USER_ALREADY_EXISTS("User Already Exists ", true),
	USER_DOES_NOT_EXISTS("User Does Not Exists ", true),
	USER_ID_CANT_BE_NULL("User Id cant be null", true);
	private String errorDescription;
	private boolean businessException;
	

	private AdminServiceErrorCode(String errorDescription_,boolean businessException) {
		this.errorDescription = errorDescription_;
		this.businessException = businessException;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	public boolean isBusinessException() {
		return businessException;
	}

}
