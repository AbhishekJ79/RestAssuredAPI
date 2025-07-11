package restAssuredTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

import java.util.*;


public class NestedJsonArray {
/*	 array of json 
	[{
		"Name" : "Abhishek",
		  "surname" : "jadhav",
		  "age" : 123,
		  "salary" : 1253
	]}
*/
	/*	 array's of json 
	[{
		
		"Name" : "Abhishek",
		  "surname" : "jadhav",
		  "age" : 123,
		  "salary" : 1253
	},
	{
		"Name" : "Pratiksha",
		  "surname" : "jadhav",
		  "age" : 321,
		  "salary" : 5321
	}]
*/
	public static void main(String[] args) throws JsonProcessingException {



		Map<String,Object> mp= new HashMap<String, Object>();   //a
		mp.put("Name", 1);
		mp.put("surname", 2);
		mp.put("age", 123);
		mp.put("salary", 1253);
		
		Map<String,Object> mp1= new HashMap<String, Object>();   //b
		  mp1.put("a",mp);

		mp1.put("Name", "Pratiksha");
		mp1.put("surname", "jadhav");
		mp1.put("age", 321);
		mp1.put("salary", 5321);
		
		List<Map<String,Object>> ls= new ArrayList<Map<String,Object>>();
		ls.add(mp);
		ls.add(mp1);
		
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
