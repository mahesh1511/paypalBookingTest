package com.paypal.bfs.test.bookingserv.test;




import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest

public class BaseTestController {
	protected MediaType contentType = MediaType.APPLICATION_JSON;
	
	protected Object getClassName() {
		return getClass();
	}
	
	protected Gson gson;
	

	
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
