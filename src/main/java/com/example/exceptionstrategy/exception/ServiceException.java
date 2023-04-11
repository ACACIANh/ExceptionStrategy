package com.example.exceptionstrategy.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

	private final ErrorCode errorCode;

	public ServiceException( String message, ErrorCode errorCode ) {
		super( errorCode.getMessage() + message );
		this.errorCode = errorCode;
	}

	public ServiceException( ErrorCode errorCode ) {
		super( errorCode.getMessage() );
		this.errorCode = errorCode;
	}
}
