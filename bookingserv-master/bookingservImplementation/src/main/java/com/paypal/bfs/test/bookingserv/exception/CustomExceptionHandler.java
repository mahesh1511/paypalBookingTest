package com.paypal.bfs.test.bookingserv.exception;



import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahesh Mishra
 * Custom Exception Handler
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.sun.media.sound.InvalidDataException;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Internal Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(DuplicateRecordFoundException.class)
    public final ResponseEntity<Booking> handleBookingFoundException(DuplicateRecordFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Duplicate Data Error", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidCheckoutdate.class)
    public final ResponseEntity<Booking> handleCheckOutException(InvalidCheckoutdate ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Invalid Check-out Date Error", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DateFormatException.class)
    public final ResponseEntity<Booking> handleInvalidDateException(DateFormatException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Invalid Date format Error", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    

}
