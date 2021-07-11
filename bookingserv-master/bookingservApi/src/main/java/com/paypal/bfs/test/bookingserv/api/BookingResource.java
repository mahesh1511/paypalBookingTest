package com.paypal.bfs.test.bookingserv.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     * @throws BookingNotFoundException 
     */
    @RequestMapping(value ="/v1/bfs/booking" , method = {RequestMethod.POST})
    @ApiOperation (value = "Add the new Booking" , consumes = "application/json" , produces = "application/json")
    @ApiResponses(value = { @ApiResponse (code =200 , message = "Successfully created Booking"),
    		@ApiResponse (code =400 , message = "Your request param contains invalid items")})
    ResponseEntity<Booking> create(@RequestBody Booking booking) throws Exception  ;

 
    
    @RequestMapping(value = "/v1/bfs/booking" , method = {RequestMethod.GET})
	ResponseEntity<List<Booking>> getAllbooking();
}
