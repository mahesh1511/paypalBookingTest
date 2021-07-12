package com.paypal.bfs.test.bookingserv.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository repository;
	
	@Override
	public List<BookingEntity> getAllBooking()
    {
        List<BookingEntity> bookingList = repository.findAll();
         
        if(bookingList.size() > 0) {
            return bookingList;
        } else {
            return new ArrayList<BookingEntity>();
        }
    }
     
    @Override
	public BookingEntity getBookingByID(Long id) throws Exception
    {
        Optional<BookingEntity> bookings = repository.findById(id);
         
        if(bookings.isPresent()) {
            return bookings.get();
        } else {
            throw new Exception("No Booking record exist for given id");
        }
    }
     
    @Override
	public BookingEntity create(@Valid BookingEntity entity) throws DataIntegrityViolationException
    {      
            entity = repository.save(entity);             
            return entity;
       
    }

}
