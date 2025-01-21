package wearetests.tests.like;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;
import com.weare.pages.FeedsPage;

import static wearetests.testdata.Users.VALID_PASSWORD;
import static wearetests.testdata.Users.VALID_USER;

public class BaseLike extends WeAreBaseWeb {
    protected FeedsPage feedsPage;

    @BeforeEach
    public void setUp() {
        feedsPage = new FeedsPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickLatestPostButton();
    }
}
