package Ecommerce.Pageobject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractClass.AbstractClass;

public class OrderPage extends AbstractClass{

	public OrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> orderProductNames;
	
	public List<String> getOrderProductName() throws InterruptedException {
		List<String> newName = orderProductNames.stream().map(product -> product.getText().trim().toUpperCase()).collect(Collectors.toList());
		System.out.print(newName);
		return newName;
	}
	
	
}
