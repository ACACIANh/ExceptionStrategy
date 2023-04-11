package com.example.exceptionstrategy.exception;

public class DomainAbException extends DomainAException {

	public DomainAbException( String attribute ) {
		super( attribute, ServiceErrorCode.DOMAIN_A_B_BAD_REQUEST );
	}
}
