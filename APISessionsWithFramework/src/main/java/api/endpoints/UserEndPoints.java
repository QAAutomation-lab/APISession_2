package api.endpoints;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	//will be used for POST operation
	public static Response createUser(User payload) {
		Response response = RestAssured.given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
							.when().post(BaseURLs.post_url);
		return response;
	}
	//will be used for GET operation
	public static Response readUser(String userName) {
		Response response = RestAssured.given()
						    .pathParam("username", userName)
							.when().get(BaseURLs.get_url);
		return response;
	}
	//will be used for PUT operation
	public static Response updateUser(String userName,User payload) {
		Response response = RestAssured.given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
						    .pathParam("username", userName)
						    .body(payload)
							.when().put(BaseURLs.update_url);
		return response;
	}
	//will be used for DELETE operation
	public static Response deleteUser(String userName) {
		Response response = RestAssured.given()
						    .pathParam("username", userName)
							.when().delete(BaseURLs.delete_url);
		return response;
	}
}
