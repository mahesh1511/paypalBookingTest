package com.paypal.bfs.test.bookingserv.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.paypal.bfs.test.bookingserv.service.BookingService;

@AutoConfigureMockMvc
public class BookingResourceTest extends BaseTestController {

	@Autowired
	BookingService service;

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
		List<BookingEntity> booking = service.getAllBooking();
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
	public void _02_createBooking_invalid_names() throws Exception {

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

		booking.setLastName("");
		mockMvc.perform(post("/v1/bfs/booking").content(serilizeToJSON(booking)).contentType(contentType))
				.andExpect(status().isBadRequest());

		booking.setLastName(
				"setFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstNamesetFirstName");
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
