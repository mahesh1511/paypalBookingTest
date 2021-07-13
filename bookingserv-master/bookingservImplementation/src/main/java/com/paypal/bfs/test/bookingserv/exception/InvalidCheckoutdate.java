package com.paypal.bfs.test.bookingserv.exception;

/**
 * 
 * @author Mahesh Mishra
 * If Check out date is before than Check-in date then
 * this exception will come
 */
public class InvalidCheckoutdate extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public InvalidCheckoutdate(String exception) {
        super("Check out date can not be before than check-in date so please check again and try again for booking");
    }
}
