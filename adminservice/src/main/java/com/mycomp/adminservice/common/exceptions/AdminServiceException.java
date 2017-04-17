package com.mycomp.adminservice.common.exceptions;


public class AdminServiceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6556780456099836156L;

	private AdminServiceErrorCode errorCode;
	public AdminServiceException(AdminServiceErrorCode errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	@Override
	public String getSource() {
		return Source.ADMINSERVICE.name();
	}

	@Override
	public String getErrorCode() {
		return errorCode.name();
	}

	@Override
	public String getErrorDescription() {
		return errorCode.getErrorDescription();
	}

	@Override
	public boolean isBusinessException() {
		return errorCode.isBusinessException();
	}

}
