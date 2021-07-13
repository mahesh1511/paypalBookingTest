package com.paypal.bfs.test.bookingserv.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;

/**
 * 
 * @author Mahesh Mishra
 * JUNIT Test cases 
 */
@AutoConfigureMockMvc
public class BookingResourceTest extends BaseTestController {

	@Autowired
	BookingRepository repository;

	@Autowired
	protected MockMvc mockMvc;

	public BookingResourceTest() {

	}

	@Test
	public void contextLoads() {
	}

	@DirtiesContext
	@Test
	public void _01_allBooking() throws Exception {
		List<BookingEntity> booking = repository.findAll();
		MvcResult result = mockMvc.perform(get("/v1/bfs/booking")).andExpect(status().isOk()).andReturn();
		String ret = result.getResponse().getContentAsString();
		assertEquals(2, booking.size());
	}

	@Test
	public void _02_createBooking_ok() throws Exception {

		Booking booking = creatBooking();
		MvcResult result = mockMvc
				.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().is2xxSuccessful()).andReturn();
	}

	@Test
	public void _03_createBooking_invalid_names() throws Exception {

		Booking booking = creatBooking();
		booking.setFirstName(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		booking.setFirstName("");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		booking.setFirstName(
				"setFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstName");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		booking.setFirstName("Mahesh");
		booking.setLastName(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setFirstName("Mahesh");
		booking.setLastName("Mishra");
		booking.setDateOfBirth(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		
		booking.setLastName("");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		booking.setLastName(
				"setFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstName");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void _04_createBooking_invalid_dates() throws Exception {
		Booking booking = creatBooking();
		
		booking.setDateOfBirth(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setDateOfBirth("15/11/18595");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setCheckIn(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setCheckIn("1511/11/19852");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setCheckOut(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setCheckOut("//////////////////////");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void _05_createBooking_invalid_prices() throws Exception {
		Booking booking = creatBooking();
		
		booking.setTotalPrice(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setTotalPrice("487384734849434983-04");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setDepositAmount(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setDepositAmount(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		booking.setCheckOut("487384734849434983-04");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void _06_createBooking_invalid_address() throws Exception {
		Booking booking = creatBooking();
		
		Address address = booking.getAddress();
		address.setCity(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		address.setState(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		address.setZipCode(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		address.setLine1(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());
		
		address.setLine2(null);
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

	}
	

	private Booking creatBooking() throws ParseException {
		Booking entity = new Booking();
		entity.setFirstName("Allen");
		entity.setLastName("border");
		entity.setDateOfBirth("1975-11-15");
		entity.setCheckIn("2021-07-11");
		entity.setCheckOut("2021-07-17");
		entity.setTotalPrice("125$");
		entity.setDepositAmount("25$");

		Address address = new Address();
		address.setLine1("Rose Land , Pie Road");
		address.setLine2("Red tower , Point 32");
		address.setCity("Sydney");
		address.setState("South");
		address.setCountry("Australia");
		address.setZipCode("54XFR7");
		entity.setAddress(address);
		return entity;
	}

}
