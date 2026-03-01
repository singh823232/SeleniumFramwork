package Ecommerce.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

    private static ExtentReports extent;   // 🔥 static reference

    public static ExtentReports getReportObject() {

        if (extent == null) {   // 🔥 create only once

            String path = System.getProperty("user.dir") + "\\reports\\index.html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Ecommerce Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Satyam Singh");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}