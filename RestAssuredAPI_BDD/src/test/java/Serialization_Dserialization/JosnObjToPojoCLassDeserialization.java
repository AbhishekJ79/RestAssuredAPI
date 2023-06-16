package Serialization_Dserialization;

import static io.restassured.RestAssured.given;

import Serialization_Dserialization.EmployeeDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JosnObjToPojoCLassDeserialization {

	
	// json object to data -deserialization
	public static void main(String[] args) throws JsonProcessingException {
      
		//json or you can add in file also
		
		String jsonBody="{\"age\":12,"
				+ "\"salary\":1233,"
				+ "\"name\":\"Abhihek\","
				+ "\"surname\":\"jadhav\""
				+ "}";
		
		
		ObjectMapper objMapper = new ObjectMapper();
		//desrialization
		EmployeeDetails emp=objMapper.readValue(jsonBody, EmployeeDetails.class);
		
		System.out.println(emp.getAge());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getSurname());
		

		given()
		//    .body(json)
		    .log().all()
		.when()
			.post()
		.then();
			

	}

}
