package TestFramework;

import org.testng.annotations.Test;

/*import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
*/

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class basics { 

	@Test
	public void getPlaceAPI() throws FileNotFoundException {
		// TODO Auto-generated method stub 

		// BaseURL or Host
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		
		//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		//System.getProperties("user.dir" + "//env.properties");
		RestAssured.baseURI = "https://maps.googleapis.com";

		given().log().all().auth().none()
		        .param("location", "-33.8670522,151.1957362")
		        .param("radius", "500")
				.param("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y")
		.when().get("/maps/api/place/nearbysearch/json")
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("results[0].name", equalTo("Sydney")).and()
				.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().header("Server", "pablo");

		/*
		 * header("dfd","fsdfds"). cookie("dsfs","csder"). body()
		 */
		// Status code of the response
		// Content type
		// Body
		// Header responses

	}

}
