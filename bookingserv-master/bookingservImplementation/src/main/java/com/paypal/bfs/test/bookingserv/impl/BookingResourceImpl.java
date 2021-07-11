package com.paypal.bfs.test.bookingserv.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.service.BookingService;

@RestController
public class BookingResourceImpl implements BookingResource {
	@Autowired
	BookingService service;

	@Override
	public ResponseEntity<Booking> create(Booking booking) throws Exception  {
		BookingEntity entity = new BookingEntity();
		try {
			
			entity.setFirstName(booking.getFirstName());
			entity.setLastName(booking.getLastName());
			SimpleDateFormat mDate = new SimpleDateFormat("yyyy-MM-dd");
			entity.setDoB(mDate.parse(booking.getDateOfBirth()));
			entity.setCheckIn(mDate.parse(booking.getCheckIn()));
			entity.setCheckOUT(mDate.parse(booking.getCheckOut()));
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
			System.out.println("parse exception");
			//e.printStackTrace();
		}
		BookingEntity updated = service.create(entity);
		Booking updatedbook =EntityToResponse(updated, new Booking());
		return new ResponseEntity<Booking>(updatedbook, new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Booking>> getAllbooking() {
		List<BookingEntity> list = service.getAllBooking();
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
		book.setDateOfBirth(entity.getDoB().toString());
		book.setCheckIn(entity.getCheckIn().toString());
		book.setCheckOut(entity.getCheckOUT().toString());
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
}
