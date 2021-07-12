package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;

public interface BookingService {

	List<BookingEntity> getAllBooking();

	BookingEntity getBookingByID(Long id) throws Exception;

	BookingEntity create(BookingEntity entity) throws DataIntegrityViolationException;

}
