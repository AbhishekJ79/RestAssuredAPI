package restAssuredTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

import java.util.*;


public class JsonArray {
/*	 array of json 
	[{
		"Name" : "Abhishek",
		  "surname" : "jadhav",
		  "age" : 123,
		  "salary" : 1253
	}]
*/
	/*	 array's of json 
	[{
		"id":1,
		"Name" : "Abhishek",
		  "surname" : "jadhav",
		  "age" : 123,
		  "salary" : 1253
	},
	{
		"Name" : "Abhishek",
		  "surname" : "jadhav",
		  "age" : 123,
		  "salary" : 1253
	}]
*/
	public static void main(String[] args) throws JsonProcessingException {
		
		Map<String,Object> mp= new HashMap<String, Object>();
		mp.put("Name", "Abhishek");
		mp.put("surname", "jadhav");
		mp.put("age", 123);
		mp.put("salary", 1253);
		
		
		List<Map<String,Object>> ls= new ArrayList<Map<String,Object>>();
		ls.add(mp);
		
		ObjectMapper mapper= new ObjectMapper();
		String jason=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ls);
		given()
		.body(jason)
		.log().all()
		.when()
		.post()
		.then()
		.log().all();
		
		
		
		
		
	}
	
}
