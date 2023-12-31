package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new User();		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	@Test(priority=1)
	public void testPostUser() {
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetUser() {
		Response response=UserEndPoints.readUser(userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		//update data  using payload
		userPayload.setUsername(faker.name().firstName());
		userPayload.setUsername(faker.name().lastName());
		userPayload.setUsername(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(userPayload.getUsername(),userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate=UserEndPoints.readUser(userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response=UserEndPoints.deleteUser(userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
