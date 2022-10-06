package restAssuredTest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.hamcrest.Matchers;


public class getRequest {
	
	@Test
	public void getEmpDetails() {
		Response res=
		given()
		//authentication
	//	.auth().basic(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		.when()
			.get("https://dummyjson.com/products/category/smartphones")
			
		.then()
		
	//	.body(JsonSchemaValidator.matchesJsonSchema("./src/test/resources/resquestData/schema.json"))
		
		.statusCode(200)
			
		.log().all()
			// exact key and value
		//	.body("products.brand[2]", Matchers.equalTo("Samsung"))
		
		.assertThat().body("products.brand[2]", Matchers.equalTo("Samsung"))
		.assertThat().body("products[0]", Matchers.hasKey("title"))
		
		.time(Matchers.lessThan(2000L))
		 .extract().response();
		
	
		//get response
		  long time=res.time();
		System.out.println("time:-"+time);
		
		//convert to string 
		String respString=res.asString();
		
		//find length
		JsonPath js= new JsonPath(respString);
		int len=js.getInt("products.size()");
		System.out.println(len);
		
		//get value from json path
		String value=js.getString("products[0].title");	
		System.out.println(value);
		
	     
		
	
		
			
		
		
		
		   
			
		
	}

	}


