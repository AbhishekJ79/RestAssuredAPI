package restAssuredTest;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

import java.util.*;

public class ComplexJosnArrayPost {
	/* Arrays with json in json
[
  {
    "Name": "Abhishek",
    "surname": "jadhav",
    "age": 123,
    "salary": 1253,
    "address": {
      "street": 1232,
      "city": "nasik",
      "state": "MH"
    }
  },
  {
    "Name": "Pratiksha",
    "surname": "jadhav",
    "age": 23,
    "salary": 123353,
    "address": {
      "street": 2,
      "city": "pune",
      "state": "MHA"
    }
  }
]

	 */
	public static void main(String[] args) throws JsonProcessingException {
		
		Map<String, Object> payload1= new LinkedHashMap<String, Object>();
		payload1.put("Name", "Abhi");
		payload1.put("surname", "jadh");
		payload1.put("age", 133);
		payload1.put("salary", 999);
		
		Map<String, Object> address= new LinkedHashMap<String, Object>();
		
		address.put("street", 244);
		address.put("city", "nsik");
		address.put("state", "MH");
		
		payload1.put("address", address);   // add inner address in payload 1
		
       List<Map<String,Object>> ls= new ArrayList<Map<String,Object>>();
       ls.add(payload1);
       
       Map<String, Object> payload2= new LinkedHashMap<String, Object>();
		payload2.put("Name", "pratiksha");
		payload2.put("surname", "jadh");
		payload2.put("age", 23);
		payload2.put("salary", 123353);
		
    Map<String, Object> address2= new LinkedHashMap<String, Object>();
		
		address2.put("street", 2);
		address2.put("city", "pune");
		address2.put("state", "MHA");
		
		payload2.put("address", address2);
		
		ls.add(payload2);
		
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
