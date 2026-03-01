package Ecommerce.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Ecommerce.AbstractClass.AbstractClass;

public class PaymentPage extends AbstractClass {


	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	By inputCountryFieldSelector = By.cssSelector("[placeholder='Select Country']");
	By country = By.cssSelector(".list-group button");

	public void fillInCountryField(String sendKeys, String countryName) {

		visibilityOfElementLocated(inputCountryFieldSelector);

		WebElement inputCountryField = driver.findElement(inputCountryFieldSelector);
		inputCountryField.sendKeys(sendKeys);

		List<WebElement> allCountryName = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(country));

		WebElement desiredCountry = allCountryName.stream()
				.filter(name -> name.getText().trim().equalsIgnoreCase(countryName)).findFirst().orElseThrow(() ->
                new RuntimeException(countryName + " not found in dropdown"));;
                desiredCountry.click();
		
	}
	
	@FindBy(css = "[class*='btnn action__submit']")
	WebElement placeOrder;
	
	public void placeOrder() {
		visibilityOfWebElement(placeOrder);
		placeOrder.click();
	}

}
