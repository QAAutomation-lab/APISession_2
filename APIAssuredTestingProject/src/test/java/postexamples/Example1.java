package postexamples;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Example1 {

	@Test
	public void testCaseForGet() {
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.get("/api/users?page=2");

		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
	}
	
	@Test
	public void testCaseForPost1() {		
		String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.post("api/users");
		
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
	}
	
	@Test
	public void testCaseForPost2() {		
		//String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		JSONObject jObject=new JSONObject();
		jObject.put("name", "morpheus");
		jObject.put("job", "leader");
		System.out.println("JSON Object: "+jObject.toJSONString());
				
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jObject.toJSONString())
		.post("api/users");
		
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
		
		//Validation
		res.then().statusCode(200);
		//Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testCaseForPost3() {

		byte[] data = null;
		try {
			data=Files.readAllBytes(Paths.get(".\\src\\test\\resourdes\\data\\UserDetails.json"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String payLoad=new String(data);
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payLoad)
		.post("api/users");
		
		String statusLine=res.getStatusLine();
		System.out.println("Status Line: "+statusLine);
		int statusCode=res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		String responseBody=res.getBody().asString();		
		System.out.println("responseBody: "+responseBody);
		
		//Validation
		res.then().statusCode(201);
	}
}
