package restAssuredTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class postTest {
	
	
	//public static HashMap<String,Object> mp= new HashMap<String,Object>();
	
	JSONObject mp = new JSONObject();
	// send request as body
	//File jsonDataInFile = new File("./src/test/resources/resquestData/request.json");
	@BeforeClass
	public  void PostData()
	{
		
		
		mp.put("ABhishek", "Name");
		mp.put("pratiksha", 23);
		
		RestAssured.baseURI="https://dummyjson.com/products";
		RestAssured.basePath="/add";
	}
	
	@Test
	public void PostDetails ()
	{
	Response resp=
		given()
		    
			.contentType("application/json")
	//		.body(jsonDataInFile);
			.body(mp)
			
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			
			.log().all()
			.assertThat().body("id", Matchers.equalTo(101))
			.extract().response();
	
//	String jsonString=resp.asString();
//	Assert.assertEquals(jsonString.contains("), DEFAULT_URL_ENCODING_ENABLED)
	
		
			
	}

	

	
	
}
