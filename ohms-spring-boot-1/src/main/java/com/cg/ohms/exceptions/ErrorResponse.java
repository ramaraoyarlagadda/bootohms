package com.cg.ohms.exceptions;

public class ErrorResponse {

	private String errorMessage;
	private String callerURL;

	public ErrorResponse(String message, String description) {

	}

	public ErrorResponse() {

	}

	public String getCallerURL() {
		return callerURL;
	}

	public void setCallerURL(String callerURL) {
		this.callerURL = callerURL;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
