package jsonexamples;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JsonObjectExample1 {

	@Test
	public void testCase1() {
		 JSONObject j = new JSONObject();
         j.put("Name", "Kotte");
         j.put("College", "BVRIT");
         j.put("Branch" , "Computer science engineering");
         j.put("Section", "CSE-C");
         System.out.println(j);   
	}
}
