package jsonexamples.day2;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

public class Example1 {
	@Test
	public void testJsonObjectExample1() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Pune");
		obj.put("age", 27);
		obj.put("salary",65000);
		System.out.println("Json Object is: \n\t"+obj);
	}
	
	@Test
	public void testJsonObjectExample2() {
		Map obj=new HashMap();
		obj.put("name", "Pune");
		obj.put("age", 27);
		obj.put("salary",65000);
		System.out.println("MAP Object is: \n\t"+obj);
		
		JSONObject ref=new JSONObject();
		ref.putAll(obj);
		
		System.out.println("Map into JSON object: "+ref);
		
		String jsonFormatText=JSONValue.toJSONString(obj);
		System.out.println("Json Text:\n\t"+jsonFormatText);
	}
	@Test
	public void testJsonArrayExample3() {
		JSONArray ar=new JSONArray();
		ar.add("Pune");
		ar.add(27);
		ar.add(65000);
		System.out.println("JSON Array: \n\t"+ar);
		
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i));
		}
	}
	
	@Test
	public void stringToJson() {
		String s1="{\"name\":\"John\", \"age\":31, \"city\":\"New York\"}";
		
		Object obj=JSONValue.parse(s1);
		JSONObject ref=(JSONObject)obj;
		System.out.println("JSON Object: \n\t"+ref);
		String name=(String)ref.get("name");
		long age=(Long)ref.get("age");
		String city=(String)ref.get("city");
		System.out.println(name);
		System.out.println(age);
		System.out.println(city);
	}
}
