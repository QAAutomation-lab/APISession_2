package restassuredOps;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Operations {
	@Test
	public void testGetMethod() {
		//specify the base URL to the RESTful web service
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		//get the RequestSpecification of the request to be sent to the server
		RequestSpecification request=RestAssured.given();
		//now you call specific function based on the requirement
		Response response=request.get();
		//once you get response object, you fetch any information for validation
		System.out.println("Response code: "+response.getStatusCode());
		System.out.println("Status line: "+response.getStatusLine());		
		System.out.println("Response :\n\t"+response.toString());		
		System.out.println("Response body  :\n\t"+response.body().asString());		
		System.out.println("Response time: \n\t"+response.getTime());
	}
	@Test
	public void testGetMethod2() {
		//specify the base URL to the RESTful web service
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		//get the RequestSpecification of the request to be sent to the server
		RequestSpecification request=RestAssured.given();
		//now you call specific function based on the requirement
		Response response=request.get();
		//once you get response object, you fetch any information for validation
		response.then().statusCode(200);
	}
	@Test
	public void testGetMethod3() {
		//specify the base URL to the RESTful web service
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		//get the RequestSpecification of the request to be sent to the server
		RequestSpecification request=RestAssured.given();
		//now you call specific function based on the requirement
		Response response=request.get();
		//once you get response object, you fetch any information for validation
		int code=response.getStatusCode();
		Assert.assertEquals(200, code);
	}
	
	@Test
	public void testGetOps() {
		RestAssured.baseURI=getUrl("admin", "admin");		
		Response respone=RestAssured.given().get();		
		String actaulResponse=respone.body().asString();	
		String expectedResponse="{\"code\":200,\"type\":\"unknown\",\"message\":\"logged in user session:";
		System.out.println("actaulResponse: \n\t"+actaulResponse);
		System.out.println("expectedResponse: \n\t"+expectedResponse);
		Assert.assertTrue(actaulResponse.startsWith(expectedResponse));
	}
	
	String getUrl(String username,String password) {
		return "https://petstore.swagger.io/v2/user/login?username="+username+"&password="+password;
	}
}
//Response body validation
//POST,PUT & Delete
//runtime payload update
