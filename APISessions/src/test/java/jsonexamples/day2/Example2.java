package jsonexamples.day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class Example2 {
	@Test
	public void jsonFileDataReading() throws FileNotFoundException, IOException, ParseException {
		JSONParser jp=new JSONParser();
		
		Object obj=jp.parse(new FileReader(".\\src\\test\\resources\\JsonFiles\\Sample.json"));
		
		JSONObject ref=(JSONObject)obj;
		
		String name=(String)ref.get("name");
		String college=(String)ref.get("college");
		
		System.out.println(name);
		System.out.println(college);
	}
}
