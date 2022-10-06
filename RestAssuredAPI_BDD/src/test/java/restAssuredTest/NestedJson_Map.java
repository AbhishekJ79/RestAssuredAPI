package restAssuredTest;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NestedJson_Map {

	public static void main(String[] args) throws JsonProcessingException {
		
		/*
{
  "Name" : "Abhishek",
  "surname" : "jadhav",
  "age" : 123,
  "salary" : 1253,
  "address" : {
    "street" : 1232,
    "city" : "nasik",
    "state" : "MH"
  }
}

		 */
		
		LinkedHashMap<String,Object> mp= new LinkedHashMap<String, Object>();

		mp.put("Name", "Abhishek");
		mp.put("surname", "jadhav");
		mp.put("age", 123);
		mp.put("salary", 1253);
		
		LinkedHashMap<String,Object> mpAddress= new LinkedHashMap<String, Object>();
		
		mpAddress.put("street", 1232);
		mpAddress.put("city", "nasik");
		mpAddress.put("state", "MH");
		
		mp.put("address",mpAddress);
		
		ObjectMapper mapper= new ObjectMapper();
		String jason=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mp);
		given()
		.body(jason)
		.log().all()
		.when()
		.post()
		.then()
		.log().all();
	}
}
