package com.example.exceptionstrategy.exception;

public class DomainAException extends ServiceException {
	public DomainAException( String message, ErrorCode errorCode ) {
		super( message, errorCode );
	}

	public DomainAException( ErrorCode errorCode ) {
		super( errorCode );
	}
}
