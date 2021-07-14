package com.paypal.bfs.test.bookingserv.exception;

/**
 * 
 * @author Mahesh Mishra
 * Booking not found Exception
 */

public class BookingNotFoundException extends RuntimeException  {
	
private static final long serialVersionUID = 1L;
	
	public BookingNotFoundException(String exception) {
        super("Booking is not found, please try with differnt Booking ID");
    }

}
