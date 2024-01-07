package stepdef;

import java.nio.file.Files;
import java.nio.file.Paths;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserDetails_stepDef {
	String payLoad = null;
	RequestSpecification req;
	Response res;
	@Given("^user has valid request URL$")
	public void user_has_valid_request_URL() {
		RestAssured.baseURI = "https://reqres.in/";
		req = RestAssured.given();
	}

	@And("^all required parameters are also available$")
	public void all_required_parameters_are_also_available() {
		req = req.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
	}

	@When("^user hits post method$")
	public void user_hits_post_method() {
		byte[] data = null;
		try {
			data = Files.readAllBytes(Paths.get(".\\src\\test\\resourdes\\data\\UserDetails.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		payLoad = new String(data);
		req.body(payLoad);
		req.when().post("api/users");
	}

	@Then("^validate response status$")
	public void validate_response_status() {
		res.then().statusCode(201);
	}

	@And("^validate response line$")
	public void validate_response_line() {
		res.then().statusLine("HTTP/1.1 201 Created");
	}
}
