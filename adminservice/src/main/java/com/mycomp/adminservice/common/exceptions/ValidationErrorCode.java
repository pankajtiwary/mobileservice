package com.mycomp.adminservice.common.exceptions;


public enum ValidationErrorCode {
	
	NO_SEARCH_CRITERIA_SELECTED("Atleast one search criteria should be selected ", true),
	EMAIL_LENGTH_EXEED("Email length should not be greater than 100 characters.", true),
	VALIDATION_CONSTRAINT("Validation Constraint", true),
	INVALID_MOBILENO_LENGTH("Mobile number length should be minimum 7 and maximum 15 characters.",true),
	INVALID_MVGNUMBER_LENGTH("MVG number length should not be greater than 100 characters.",true),
	INVALID_QUERY_AREA_LENGTH("Query area length should not be greater than 100 characters.",true),
	INVALID_PASSPORT_LENGTH("Passport length should not be more than 255 characters",true),
	INVALID_SOUTH_AFRICA_ID_LENGTH("South African ID length should not be more than 255 characters",true),
	INVALID_DESCRIPTION_LENGTH("Description length should not be more than 500 characters",true),
	INVALID_QUERY_TYPE("Query type should not be a more than 255 characters",true), 
	INVALID_QUERY_RESOLUTIONID("Query resolution type id is invalid",true);
	
	private String errorDescription;
	private boolean businessException;
	private ValidationErrorCode(String errorDescription_, boolean businessException) {
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
