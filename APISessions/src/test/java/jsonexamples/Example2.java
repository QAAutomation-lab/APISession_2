package jsonexamples;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Example2 {

	@Test
	public void createJsonObject() {
		
		 //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");        
       System.out.println("Employee Details: \n\t"+employeeDetails);
        
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
        System.out.println("Employee Object: \n\t"+employeeObject);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");
        System.out.println("Employee Details2: \n\t"+employeeDetails2);
         
        JSONObject employeeObject2 = new JSONObject(); 
        employeeObject2.put("employee", employeeDetails2);
        System.out.println("Employee Object: \n\t"+employeeObject);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
        
        for(int i=0;i<employeeList.size();i++) {
        	System.out.println(employeeList.get(i));
        }
	}
}
