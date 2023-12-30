package jsonexamples;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Example1 {

	@Test
	public void createJsonObject() {
		
		JSONObject obj=new JSONObject();
		obj.put("Name", "Shailesh");
		obj.put("Job", "IT");
		obj.put("Mobile", 987654256);
		System.out.println(obj);
		
		JSONObject obj2=new JSONObject();
		obj2.put("Company", "XYZ");
		obj2.put("Role", "Automation Tester");
		obj2.put("Salary", 45000);
		System.out.println(obj2);
		
		System.out.println("Role value is: "+obj2.get("Role"));
	}
}
