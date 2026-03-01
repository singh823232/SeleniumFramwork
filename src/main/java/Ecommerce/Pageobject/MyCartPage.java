package Ecommerce.Pageobject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractClass.AbstractClass;



public class MyCartPage extends AbstractClass{
	
	WebDriver driver;
	
	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By itemsSelector = By.cssSelector(".items");
	
	public List<String> getItemsOfCart() {
		visibilityOfAllElementsLocatedBy(itemsSelector);
		List<WebElement> itemsInCart = driver.findElements(itemsSelector);
		
		return itemsInCart.stream().map(item -> item.findElement(By.cssSelector("h3")).getText())
				.collect(Collectors.toList());
	}
	
	By spinner = By.cssSelector(".ngx-spinner-overlay");
	By checkoutButton = By.cssSelector(".totalRow button");
	
	public PaymentPage goToCheckout() throws InterruptedException {

		scrollPage(driver.findElement(checkoutButton));
//		invisiblOfElement(spinner);
		Thread.sleep(1000);
		invisiblOfElement(By.id("toast-container"));		
		driver.findElement(checkoutButton).click();
		return new PaymentPage(driver);
		
	}

}
/*-----------------------------------------------------------------------------------------------------*/
	
	
	

	
