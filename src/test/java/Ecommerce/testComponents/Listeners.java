package Ecommerce.testComponents;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners implements ITestListener {
	
	private static ExtentReports extent = ExtendReporterNG.getReportObject();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	
	//Threadsafe for parallel execution
	
	

	@Override
	public void onTestStart(ITestResult result) {
			ExtentTest test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass("Test Passed");
	}

	@Override
	 public void onTestFailure(ITestResult result) {

        ExtentTest test = extentTest.get();

        if (test == null) {
            test = extent.createTest(result.getMethod().getMethodName());
            extentTest.set(test);
        }

        test.fail(result.getThrowable());

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String filePath = System.getProperty("user.dir")
                    + "\\reports\\ScreenShot\\"
                    + result.getMethod().getMethodName() + ".png";

            FileUtils.copyFile(source, new File(filePath));

            test.addScreenCaptureFromPath(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
    public void onFinish(ITestContext context) {
        extent.flush();   // VERY IMPORTANT
    }

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}
	
	
}










