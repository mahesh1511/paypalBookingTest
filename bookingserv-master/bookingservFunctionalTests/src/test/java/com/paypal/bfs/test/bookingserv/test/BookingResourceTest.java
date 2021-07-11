package com.paypal.bfs.test.bookingserv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.service.BookingService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
// @AutoConfigureTestDatabase(replace = NONE)
class BookingResourceTest extends BaseTestController {

	@Autowired
	BookingService service;
	@Autowired
	private MockMvc mvc;

	

	public BookingResourceTest() {
		
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void _01_allBooking() throws Exception {
		List<BookingEntity> booking = service.getAllBooking();
		MvcResult result = mvc.perform(get("/v1/bfs/booking"))
				.andExpect(status().isOk()).andReturn();
		String ret = result.getResponse().getContentAsString();
		assertEquals(2, booking.size());
	}

	@Test
	public void _02_createBooking() throws Exception {

		BookingEntity entity = new BookingEntity();
		entity.setFirstName("Allen");
		entity.setLastName("border");
		entity.setDoB(new SimpleDateFormat().parse("1975-11-15"));
		entity.setCheckIn(new SimpleDateFormat().parse("2021-07-11"));
		entity.setCheckOUT(new SimpleDateFormat().parse("2021-07-17"));
		entity.setTotalPrice("125$");
		entity.setDepositAmount("25$");
		entity.setAddressLine1("Rose Land , Pie Road");
		entity.setAddressLine2("Red tower , Point 32");
		entity.setCity("Sydney");
		entity.setState("South");
		entity.setCountry("Australia");
		entity.setZipCode("54XFR7");
		MvcResult result = mockMvc
				.perform(
						post("/v1/bfs/booking").content(serilizeToJSON(entity))
								.contentType(contentType))
				.andExpect(status().is2xxSuccessful()).andReturn();
	}

}
