package restAssuredTest;

import java.util.LinkedHashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.*;

public class JsonMap_PostBody {

	public static void main(String[] args) {


		LinkedHashMap<String,Object> mp= new LinkedHashMap<String, Object>();

		mp.put("Name", "Abhishek");
		mp.put("surname", "jadhav");
		mp.put("age", 123);
		
		
		given()
		.body(mp)
		.log().all()
		.when()
		.post()
		.then()
		.log().all();
		
		
	
	}

}
