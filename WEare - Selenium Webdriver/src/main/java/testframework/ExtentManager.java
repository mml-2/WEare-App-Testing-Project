package testframework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = "reports/extentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static synchronized ExtentTest createTest(String testName, String description) {
        ExtentTest extentTest = getExtentReports().createTest(testName, description);
        test.set(extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
