package jsonSimpleLibTests;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class readingDataFromJSONUsingJsonSimpleLibrary {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader(".\\data\\employee.json");

		Object obj = jsonparser.parse(reader);

		JSONObject empjsonobject = (JSONObject) obj;

		String fname = (String) empjsonobject.get("firstName");
		System.out.println(fname);

		JSONArray addressArray = (JSONArray) empjsonobject.get("address");
		
		for(int i = 0;i <addressArray.size() ;i++) {
			
			JSONObject address = (JSONObject) addressArray.get(i);
			String street = (String) address.get("street");
			String city = (String) address.get("city");
			String state = (String) address.get("state");
			
			System.out.println(street + " ### "+ city + " ### " +state);
		}

	}

}
