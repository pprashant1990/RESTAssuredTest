package gsonLibTests.copy;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import jsonFiles.Address;
import jsonFiles.Person;

public class readingDataFromJSONUsingGsonLibrary {

	public static void main(String[] args) throws FileNotFoundException {

		FileReader reader = new FileReader(".\\data\\employee.json");

		Gson gson = new Gson();

		Person person = gson.fromJson(reader, Person.class);

		// access data

		// System.out.println(person.getFirstName());

//		for(Address address : person.getAddress()) {
//			System.out.println(address.getCity());X
//			
//		}

		for (Address address : person.getAddress()) {
			//System.out.println(address.getState());
			if (address.getState().equalsIgnoreCase("TL")) {				
				System.out.println(person.getAddress().get(0).getStreet());
			}
		}
	}

}
