package coopAPIsTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UnlockBarn extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		
		logger.info("******************Unlock Barn Test Case is Started.*************************");
		RestAssured.baseURI = BaseClass.getCoopBaseURI();
		RestAssured.basePath = "barn-unlock";
		
	response = given()
		.auth()
		.oauth2(BaseClass.getCoopApiToken())
		.when()
		.post()
		.then()
		.extract()
		.response();	
	
	System.out.println("Response is "+response.asPrettyString());
	}
	
	@Test
	public void testStatusCode() {
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testAction() {
		String actualAction = response.jsonPath().get("action");
		String expectedAction = "barn-unlock";
		Assert.assertEquals(actualAction, expectedAction);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*******************Unlock Bark Test Case is Completed*************************");
	}
}