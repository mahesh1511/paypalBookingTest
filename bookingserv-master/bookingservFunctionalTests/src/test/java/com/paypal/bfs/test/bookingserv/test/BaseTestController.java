package com.paypal.bfs.test.bookingserv.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class BaseTestController {
	
	protected MockMvc mockMvc;
	
	protected MediaType contentType;
	
	@Autowired
	protected  WebApplicationContext wac;
	
	protected Object getClassName() {
		return getClass();
	}
	
	protected Gson gson;
	
	@Before
	
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		this.contentType = MediaType.APPLICATION_JSON;
		System.err.println("in before "+getClassName());
	}
	
	@After	
	public void after() {
		System.err.println("in after "+getClassName());
	}
	
	protected String serilizeToJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/*
	 * public <T> T getObject(String ret , String objectName , Class<T> clazz) {
	 * 
	 * T obj = null; try { obj = gson.fromJson( new
	 * JSONObject(ret).toJSONString(objectName) clazz); } catch (JsonSyntaxException
	 * | JSONException e) { e.printStackTrace(); } return obj; }
	 */
	

}
