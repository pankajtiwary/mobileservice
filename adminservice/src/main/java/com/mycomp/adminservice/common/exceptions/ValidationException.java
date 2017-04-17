package com.mycomp.adminservice.common.exceptions;

public class ValidationException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	public ValidationException(ValidationErrorCode errorCode, String msg) {
		super(msg);
		this.msg = msg;
		this.errorCode = errorCode;
	}
	
	private ValidationErrorCode errorCode;


	@Override
	public String getSource() {
		return Source.VALIDATION.name().toUpperCase();
	}

	@Override
	public String getErrorDescription() {
		if(this.errorCode.equals(ValidationErrorCode.VALIDATION_CONSTRAINT)) {
			return msg;
		}
		return this.errorCode.getErrorDescription();
	}

	@Override
	public boolean isBusinessException() {
		return this.errorCode.isBusinessException();
	}

	@Override
	public String getErrorCode() {
		return this.errorCode.name().toUpperCase();
	}

}
