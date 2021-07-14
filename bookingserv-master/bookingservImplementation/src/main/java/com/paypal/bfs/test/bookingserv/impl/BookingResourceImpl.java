package com.paypal.bfs.test.bookingserv.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exception.BookingNotFoundException;
import com.paypal.bfs.test.bookingserv.exception.CustomExceptionHandler;
import com.paypal.bfs.test.bookingserv.exception.DateFormatException;
import com.paypal.bfs.test.bookingserv.exception.DuplicateRecordFoundException;
import com.paypal.bfs.test.bookingserv.exception.InvalidCheckoutdate;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;

/**
 * 
 * @author Mahesh Mishra
 * Main class for task
 */
@RestController
public class BookingResourceImpl implements BookingResource {
	
	@Autowired
	BookingRepository repository;
	
	@Autowired
	CustomExceptionHandler custom;
	
	DateFormat mDate = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public ResponseEntity<Booking> create(Booking booking) throws Exception  {
		
		BookingEntity entity = new BookingEntity();
		
		try {
			
			String fName = booking.getFirstName();
			String lName = booking.getLastName();
			Date mDateofBirth = mDate.parse(booking.getDateOfBirth());
			Date mCheckIn = mDate.parse(booking.getCheckIn());
			Date mCheckout = mDate.parse(booking.getCheckOut());
			/**
			 * Validation Check if Check out dates is before Check-in date
			 */
			if(mCheckIn.after(mCheckout)) 
				return custom.handleCheckOutException(new InvalidCheckoutdate("Check out date can not be before than check-in date so please check again and try again for booking"), null);
			
			
			/**
			 *  Validation of Duplicate data 
			 *  Duplicate data check will done based on 5 Parameter
			 *  1. First Name 
			 *  2. Second Name 
			 *  3. Date of Birth
			 *  4. Check-in Date
			 *  5. Check-out Date
			 */			
			if(repository.dataexists(fName, lName, mDateofBirth, mCheckIn, mCheckout)>0) 
				return custom.handleDuplicateBookingException(new DuplicateRecordFoundException("This record is already exist , please try with different booking"), null);
			
			
			entity.setFirstName(fName);
			entity.setLastName(lName);			
			entity.setDoB(mDateofBirth);
			entity.setCheckIn(mCheckIn);
			entity.setCheckOUT(mCheckout);
			entity.setDepositAmount(booking.getDepositAmount());
			entity.setTotalPrice(booking.getTotalPrice());
			entity.setAddressLine1(booking.getAddress().getLine1());
			entity.setAddressLine2(booking.getAddress().getLine2());
			entity.setCity(booking.getAddress().getCity());
			entity.setCountry(booking.getAddress().getCountry());
			entity.setState(booking.getAddress().getState());
			entity.setZipCode(booking.getAddress().getZipCode());
			
		} 
		
		catch (ParseException e) {
			return custom.handleInvalidDateException(new DateFormatException("Please check the Date format and try again with booking"), null);
		}
		BookingEntity updated = repository.save(entity);
		Booking updatedbook =EntityToResponse(updated, new Booking());
		return new ResponseEntity<Booking>(updatedbook, new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Booking>> getAllbooking() {
		List<BookingEntity> list = repository.findAll();
		List<Booking> bookings = new ArrayList<Booking>();

		for (BookingEntity entity : list) {
			Booking book = new Booking();
			Booking updatedbook =EntityToResponse(entity, book);
			bookings.add(updatedbook);
		}

		return new ResponseEntity<List<Booking>>(bookings, new HttpHeaders(), HttpStatus.OK);
	}

	private Booking EntityToResponse(BookingEntity entity, Booking book) {
		book.setId((int) entity.getId());
		book.setFirstName(entity.getFirstName());
		book.setLastName(entity.getLastName());
		book.setDateOfBirth(mDate.format(entity.getDoB()));
		book.setCheckIn(mDate.format(entity.getCheckIn()));
		book.setCheckOut(mDate.format(entity.getCheckOUT()));
		book.setTotalPrice(entity.getTotalPrice());
		book.setDepositAmount(entity.getDepositAmount());
		Address address = new Address();		
		address.setCity(entity.getCity());
		address.setState(entity.getState());
		address.setLine1(entity.getAddressLine1());
		address.setLine2(entity.getAddressLine2());
		address.setCountry(entity.getCountry());
		address.setZipCode(entity.getZipCode());
		book.setAddress(address);
		
		return book;
	}

	@Override
	public ResponseEntity<Booking> getBookingbyID(Long id) {
		Optional<BookingEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
            BookingEntity mEntity = entity.get();
			Booking updatedbook =EntityToResponse(mEntity, new Booking());
			return new ResponseEntity<Booking>(updatedbook, new HttpHeaders(), HttpStatus.OK);
        } else {
        	return custom.handleNoBookingException(new BookingNotFoundException("Booking is not found, please try with differnt Booking ID"), null);
        }
		
	}
	
	
}
