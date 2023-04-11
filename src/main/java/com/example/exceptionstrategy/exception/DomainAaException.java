package com.example.exceptionstrategy.exception;

public class DomainAaException extends DomainAException {

	public DomainAaException() {
		super( ServiceErrorCode.DOMAIN_A_A_NOTFOUND );
	}

}
