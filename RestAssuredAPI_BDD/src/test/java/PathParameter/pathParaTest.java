package PathParameter;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class pathParaTest {

	public static void main(String[] args) {


		given()
		
		.log().all()
//		.baseUri("https://restful-booker.herokuapp.com/")
//		.basePath("{basePath}/{bookingID}")
//		.pathParam("basePath", "booking")
//		.pathParam("bookingID", 2)
		
		.when()
			.get("https://restful-booker.herokuapp.com/{basePath}/{bookingID}","booking",2)
	
		.then()
			.log().all();
		
		

	}

}
