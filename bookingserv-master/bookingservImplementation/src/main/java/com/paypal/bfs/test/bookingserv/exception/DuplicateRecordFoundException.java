package com.paypal.bfs.test.bookingserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Mahesh Mishra
 * Duplicate data Exception
 *
 */
@ResponseStatus(HttpStatus.OK)
public class DuplicateRecordFoundException extends RuntimeException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateRecordFoundException(String exception) {
        super("This record is already exist , please try with different booking");
    }
}
