package jacksonLibTests;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jsonFiles.Address;
import jsonFiles.Person;

public class readingDataFromJSONUsingJacksonLibrary {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		// create an object for ObjectMapper class
		ObjectMapper objectmapper = new ObjectMapper();

		// read the json file
		File file = new File(".\\data\\employee.json");

		// read json data from the file and map to the person class

		Person person = objectmapper.readValue(file, Person.class);

		// access data
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getAddress().get(1).getCity());
		System.out.println("\n");

		for (Address address : person.getAddress()) {
			System.out.println(address.getStreet());
			System.out.println(address.getCity());
			System.out.println(address.getState());
			System.out.println("\n");
		}

		/*
		 * for(int i = 0 ; i <person.getAddress().size() ;i++) {
		 * 
		 * System.out.println(person.getAddress().get(i).getCity()); }
		 */

	}

}
