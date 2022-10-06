package CreatedJSONinJOSNobjUsingPOJO;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostCLass {

	public static void main(String[] args) throws JsonProcessingException {

		
/*		{
		  "name" : "Abhishek",
		  "salary" : 12322,
		  "age" : 27,
		  "address" : {
		    "gateNo" : 144,
		    "buldingName" : "shree shraddha"
		  }
		}
*/

		ActualPayloadEmpDetails payload= new ActualPayloadEmpDetails();
		payload.setName("Abhishek");
		payload.setAge(27);
		payload.setSalary(12322);
		address add= new address();
		add.setGateNo(144);
		add.setBuldingName("shree shraddha");
		payload.setAddress(add);
		
		ObjectMapper mapper= new ObjectMapper();
		String josnPayload =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
		
		given()
		.log().all()
		.body(josnPayload)
		.when()
			.post()
			
			.then()
			.log().all();

	}

}
