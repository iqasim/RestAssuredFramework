package coopAPIsTestCases;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class ChickenFeed extends BaseClass {

	Response res;
	
	@BeforeClass
	public void setUp() {
		
		logger.info("*************Started Execution of Chicken Feed Test Case");
		
		RestAssured.baseURI=BaseClass.getCoopBaseURI();
		RestAssured.basePath = "chickens-feed";
		
		res = RestAssured.given().
		auth().
		oauth2(BaseClass.getCoopApiToken()).
		when().
		post().
		then().
		extract().
		response();
	}
	
	
	@Test
	public void testFeedChicken() {
		
		assertEquals(res.getStatusCode(), 200);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*************Chicken Feed test case is completed.");
	}
	

}
