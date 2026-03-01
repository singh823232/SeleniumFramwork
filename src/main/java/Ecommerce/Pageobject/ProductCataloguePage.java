package Ecommerce.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractClass.AbstractClass;

public class ProductCataloguePage extends AbstractClass {

	public ProductCataloguePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> cards;

	By spinner = By.cssSelector(".ngx-spinner-overlay");

	public void productAddToCart(String itemName) {

		WebElement product = cards.stream()
				.filter(card -> card.findElement(By.tagName("b")).getText().equalsIgnoreCase(itemName)).findFirst()
				.orElseThrow(() -> new RuntimeException(itemName + " not found in product list"));

		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		invisiblOfElement(spinner);
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		invisiblOfElement(By.id("toast-container"));

	}

}
