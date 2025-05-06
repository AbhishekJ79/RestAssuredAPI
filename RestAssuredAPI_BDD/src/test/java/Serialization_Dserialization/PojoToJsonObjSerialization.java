package Serialization_Dserialization;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJsonObjSerialization {

	//java object to json -serialization
	public static void main(String[] args) throws JsonProcessingException {


		EmployeeDetails emp = new EmployeeDetails();
		emp.setAge(12);
		emp.setName("Abhihek");
		emp.setSurname("jadhav");
		emp.setSalary(1233);
		
		
		ObjectMapper objMapper = new ObjectMapper();
		String json=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp); // convert into pretty json as string and pass as body

		//	System.out.println(json);
		//its now converted into json payload and pass as a body
		
		given()
		    .body(json)
		    .log().all()
		.when()
			.post()
		.then();
			

	}

}
