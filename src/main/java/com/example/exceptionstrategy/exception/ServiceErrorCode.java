package com.example.exceptionstrategy.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ServiceErrorCode implements ErrorCode {
	INTERNAL_GLOBAL_ERROR( HttpStatus.INTERNAL_SERVER_ERROR, "internal_server_error" ),
	DOMAIN_A_A_NOTFOUND( HttpStatus.NOT_FOUND, "domain_a_a_notfound" ),
	DOMAIN_A_B_BAD_REQUEST( HttpStatus.BAD_REQUEST, "domain_a_b_bad_request" );

	private final HttpStatus httpStatus;
	private final String message;

	// 개선방향 - attribute 값을 받을수 있게
	ServiceErrorCode( HttpStatus httpStatus, String message ) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
