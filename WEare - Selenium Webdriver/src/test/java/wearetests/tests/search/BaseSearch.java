package wearetests.tests.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.VALID_PASSWORD;
import static wearetests.testdata.Users.VALID_USER;

public class BaseSearch extends WeAreBaseWeb {

    protected By myName = By.xpath("//h1");
    public String loggedInUsername;

    protected String getName() {
        WebElement name = driver().findElement(myName);
        return name.getText();
    }

    public void searchForProfession(String profession) {
        homePage.searchForProfession(profession);
    }

    public void getUsername() {
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickMyAccountButton();
        loggedInUsername = getName();
        driver().findElement(By.xpath("//a[@class='navbar-brand']")).click();
    }

    public void searchForName(String name) {
        homePage.searchForName(name);
    }

    public void clickSearchButton() {
        homePage.clickSearchButton();
    }
}
