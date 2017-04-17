package com.mycomp.adminservice.common.exceptions;

public class ErrorResponse {
		public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public boolean isBusinessException() {
		return businessException;
	}
	public void setBusinessException(boolean businessException) {
		this.businessException = businessException;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	private String errorCode;
	private String errorDescription;
	private boolean businessException = false;
	private String source;
	
	public static ErrorResponse build(BaseException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setBusinessException(e.isBusinessException());
		errorResponse.setErrorCode(e.getErrorCode());
		errorResponse.setErrorDescription(e.getErrorDescription());
		errorResponse.setSource(e.getSource());
		return errorResponse;
	}


}
