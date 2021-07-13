package com.paypal.bfs.test.bookingserv.exception;

/**
 * 
 * @author Mahesh Mishra
 * Invalid Date format Exception
 */

public class DateFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DateFormatException(String exception) {
        super("Please check the Date format and try again with booking");
    }
}
