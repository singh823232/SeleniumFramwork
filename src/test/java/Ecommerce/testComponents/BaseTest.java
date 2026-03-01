package Ecommerce.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Ecommerce.Pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Utility{

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() {

		// read global property variable
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties";
		Properties prop = new Properties();

		try (FileInputStream fis = new FileInputStream(path)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// satyam
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") :  prop.getProperty("browser");

		// if fireFox -> run with firefox
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		System.out.println(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;

	}

	


	
	
	@BeforeMethod
	public LandingPage launchApplication() {

		initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo("https://rahulshettyacademy.com/client");

		return landingPage;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
