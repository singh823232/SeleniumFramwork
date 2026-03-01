package Ecommerce.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecommerce.Pageobject.MyCartPage;
import Ecommerce.Pageobject.OrderPage;
import Ecommerce.Pageobject.PaymentPage;
import Ecommerce.Pageobject.ProductCataloguePage;
import Ecommerce.testComponents.BaseTest;

public class StandAloneTest extends BaseTest {

//	String[] productNames = { "ZARA COAT 3", "iphone 13 pro" };

	@DataProvider(name = "productNames")
	public Object[][] data() {
		return new Object[][] { { "ZARA COAT 3" }, { "iphone 13 pro" }, {"ADIDAS ORIGINAL"} };
	}

	@Test( dataProvider = "productNames")
	public void SubmitOrder(String productNames) throws InterruptedException {

		ProductCataloguePage productCat = landingPage.login("singh823232@gmail.com", "Samsung@135");
		Assert.assertTrue(landingPage.getSuccessMessage().contains("Successfully"));

		productCat.productAddToCart(productNames);
		MyCartPage myCartPage = productCat.goToCartPage();

		PaymentPage paymentPage = myCartPage.goToCheckout();
		paymentPage.fillInCountryField("Ind", "INDIa");
		
		paymentPage.placeOrder();

	}

//	

	@Test(	dataProvider="productNames")
	public void productErrorValidation(String productName) throws InterruptedException {

		ProductCataloguePage productCat = landingPage.login("singh823232@gmail.com", "Samsung@135");
		OrderPage orderPage = productCat.goToOrderPage();
		List<String> orderProductName = orderPage.getOrderProductName();
		
		Assert.assertTrue(orderProductName.contains(productName.toUpperCase()), productName + " Expected Conditions not Matched");
	}

}
