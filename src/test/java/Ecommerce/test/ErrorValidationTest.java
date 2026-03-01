package Ecommerce.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecommerce.testComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(dataProvider="loginData", retryAnalyzer = Ecommerce.testComponents.Retry.class)
	public void LoginErrorValidation(HashMap<String, String> input) {
		landingPage.login(input.get("email"), input.get("password"));
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@DataProvider(name = "loginData")
	public  Object[][] data() throws Exception{
		
		String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\Ecommerce\\data\\loginData.json";
		ArrayList<HashMap<String, String>> input = getJsonDataToMap(filepath);
		
		
		
		return new Object[][] {{input.get(0)}, {input.get(1)}};
	}
	
	
	

}
