package com.example.exceptionstrategy.controller;

import com.example.exceptionstrategy.exception.ErrorCode;
import com.example.exceptionstrategy.exception.ServiceErrorCode;
import com.example.exceptionstrategy.exception.ServiceException;
import com.example.exceptionstrategy.model.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	private final MessageSource messageSource;

	@ExceptionHandler( ServiceException.class )
	private ResponseEntity< ? > handleExceptionServer( final ServiceException serviceException ) {

		return ResponseEntity.status( serviceException.getErrorCode().getHttpStatus() )
				.body( makeErrorResponse( serviceException.getErrorCode(), serviceException.getMessage() ) );
	}

	@ExceptionHandler( Exception.class )
	public ResponseEntity< ? > handleExceptionInternal( final Exception e ) {

		ErrorCode errorCode = ServiceErrorCode.INTERNAL_GLOBAL_ERROR;

		return ResponseEntity.status( errorCode.getHttpStatus() )
				.body( makeErrorResponse( errorCode, e.getMessage() ) );
	}

	private ExceptionResponse makeErrorResponse( final ErrorCode errorCode ) {
		// 개선방향 - messageKey 이용하여 여러 language 지원
		// ex) String message = messageSource.getMessage( errorCode.getMessage(), null, Locale.KOREAN );
		return new ExceptionResponse( errorCode.name(), errorCode.getMessage() );
	}

	private ExceptionResponse makeErrorResponse( final ErrorCode errorCode, final String message ) {
		return new ExceptionResponse( errorCode.name(), message );
	}
}
