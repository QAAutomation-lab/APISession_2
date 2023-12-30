package jsonexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadJsonFile2 {

	@Test
	public void testCase1() throws FileNotFoundException, IOException, ParseException {
		// file name is File.json
        Object o = new JSONParser().parse(new FileReader(".\\src\\test\\resources\\JsonFiles\\Sample.json"));

        JSONObject j = (JSONObject) o;
        String Name = (String) j.get("name");
        String College = (String ) j.get("college");
        System.out.println("Name : "+ Name);
        System.out.println("College :" +College);
  
	}
}
