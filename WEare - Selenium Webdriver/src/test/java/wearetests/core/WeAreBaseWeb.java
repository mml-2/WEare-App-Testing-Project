package wearetests.core;

import com.weare.pages.HomePage;
import com.weare.pages.LoginPage;
import com.weare.pages.RegisterPage;
import com.weare.pages.ResultsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import testframework.ExtentManager;
import testframework.ExtentTestWatcher;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;
@ExtendWith(ExtentTestWatcher.class)

public class WeAreBaseWeb extends BaseWebTest {
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ResultsPage resultsPage;

    @BeforeAll
    public static void setupSuite() {
        ExtentManager.getExtentReports();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
            String testName = testInfo.getDisplayName();
            String testDescription = testInfo.getTags().toString(); // Optional
            ExtentManager.createTest(testName, testDescription);
            ExtentManager.getTest().info("Starting test: " + testName);

            registerPage = new RegisterPage();
            homePage = new HomePage();
            loginPage = new LoginPage();
            resultsPage = new ResultsPage();

        ChromeOptions options = new ChromeOptions();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
    }


    @BeforeAll
    public static void beforeAll() {
    }

    @AfterEach
    public void afterTest() {
        ExtentManager.getTest().info("Test Finished");

        if (driver().getTitle().contains("Error")) {  // Customize the condition based on the actual error check
            ExtentManager.getTest().fail("Test failed due to some condition in the browser");
        }

        driver().close();
    }

    @AfterAll
    public static void tearDownSuite() {
        ExtentManager.getExtentReports().flush();
    }


}