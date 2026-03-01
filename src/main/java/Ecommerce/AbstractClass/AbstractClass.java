package Ecommerce.AbstractClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecommerce.Pageobject.MyCartPage;
import Ecommerce.Pageobject.OrderPage;

public class AbstractClass {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	By cartButton = By.cssSelector("[routerlink*='cart']");
	By spinner = By.cssSelector(".ngx-spinner-overlay");

	public MyCartPage goToCartPage() throws InterruptedException {
//		elementToClickable(cartButton);
		Thread.sleep(1000);
		invisiblOfElement(By.id("toast-container"));
		driver.findElement(cartButton).click();
		return new MyCartPage(driver);
	}

	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement orderPage;

	public OrderPage goToOrderPage() throws InterruptedException {
//		invisiblOfElement(spinner);
		sleepThread();
		elementToClickable(By.cssSelector("[routerlink='/dashboard/myorders']"));
		orderPage.click();
		return new OrderPage(driver);
	}

	public void scrollPage(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
//		Thread.sleep(2000);
	}
	
	public void sleepThread() throws InterruptedException {
		Thread.sleep(1000);
	}

	public void removedFromDOM(By findBy) {
		wait.until(ExpectedConditions.numberOfElementsToBe(findBy, 0));
	}

	public void elementToClickable(By findBy) {
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void visibilityOfElementLocated(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void visibilityOfWebElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void visibilityOfAllElementsLocatedBy(By findBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}

	public void invisiblOfElement(By findBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

}
