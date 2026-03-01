package Ecommerce.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Ecommerce.AbstractClass.AbstractClass;

public class LandingPage extends AbstractClass {

	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	private WebElement userMail;

	@FindBy(id = "userPassword")
	private WebElement userPassword;

	@FindBy(id = "login")
	private WebElement login;

	private By successToastMessageSelector = By.xpath("//div[@aria-label='Login Successfully']");

	public ProductCataloguePage login(String user, String password)  {
		userMail.sendKeys(user);
		userPassword.sendKeys(password);
		login.click();
		return new ProductCataloguePage(driver);
	}

	@FindBy(css = ".ng-star-inserted")
	WebElement errorMessage;

	public String getErrorMessage() {
		visibilityOfWebElement(errorMessage);
		return errorMessage.getText();
	}

	public String getSuccessMessage() {

		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(successToastMessageSelector));
		return toast.getText();

	}

	public void goTo(String URL) {
		driver.get(URL);
	}

}
