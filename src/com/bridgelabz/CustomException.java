package com.bridgelabz;

	public class CustomException extends Exception {
	    public ExceptionType type;

	    public CustomException(ExceptionType type, String message) {
	        super(message);
	        this.type = type;
	    }

	    public enum ExceptionType {
	        UPDATE_FAIL
	    }
	}