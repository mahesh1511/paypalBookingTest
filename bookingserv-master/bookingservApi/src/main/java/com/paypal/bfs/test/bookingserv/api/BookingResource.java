package com.paypal.bfs.test.bookingserv.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RequestMapping("/v1/bfs/booking")
public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     *  
     */
	@PostMapping
    ResponseEntity<Booking> create(@RequestBody @Valid Booking booking) throws Exception  ;

 
    /**
     * 
     * @return List of booking 
     */
    
	@GetMapping
	ResponseEntity<List<Booking>> getAllbooking();
    
    
    /**
     * 
     * @return Find Booking by ID 
     */
    @GetMapping("/{id}")
  	ResponseEntity<Booking> getBookingbyID(@PathVariable("id") Long id);
}
