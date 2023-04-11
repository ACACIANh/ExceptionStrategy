package com.example.exceptionstrategy.controller;

import com.example.exceptionstrategy.exception.DomainAaException;
import com.example.exceptionstrategy.exception.DomainAbException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

	@GetMapping( "/" )
	public void redirect( HttpServletResponse response ) throws IOException {
		response.sendRedirect( "/test" );
	}

	@GetMapping( "/test" )
	public ResponseEntity< ? > test(
			@RequestParam( required = false ) String test ) {
		if ( StringUtils.isNotBlank( test ) && test.equals( "a" ) ) {
			throw new DomainAaException();
		}

		if ( StringUtils.isNotBlank( test ) && test.equals( "b" ) ) {
			throw new DomainAbException( " b is wrong" );
		}

		if ( StringUtils.isNotBlank( test ) ) {
			throw new RuntimeException( test );
		}

		return ResponseEntity.ok( "test" );
	}

}
