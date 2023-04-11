package com.example.exceptionstrategy.exception;

@Deprecated( since = "not use" )
public class DomainBException extends ServiceException {

	public DomainBException( String message, ErrorCode errorCode ) {
		super( message, errorCode );
	}

	public DomainBException( ErrorCode errorCode ) {
		super( errorCode );
	}
}
