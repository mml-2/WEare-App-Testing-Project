package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseWeArePage {
    public HomePage() {
        super("");
    }

    private final By registerButton = By.xpath("//li[@class='nav-item cta mr-md-1']");
    private final By signInButton = By.xpath("//li[@class='nav-item cta cta cta-colored']");
    private final By latestPostButton = By.xpath("//a[text()='Latest Posts']");
    private final By logoutButton = By.xpath("//a[text()='LOGOUT']");
    private final By addNewPostButton = By.xpath("//*[@id=\"ftco-nav\"]/ul/li[8]/a");
    private final By searchForProfessionField = By.id("searchParam1");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By adminPanelButton = By.xpath("//a[@href='/admin']");
    private final By searchForNameField = By.id("searchParam2");
    private final By myAccountButton = By.xpath("//a[contains(text(),'Personal')]");

    public void clickRegisterButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void clickMyAccountButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(myAccountButton)).click();
    }

    public void clickLogoutButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    public By getRegisterButtonLocator() {
        return registerButton;
    }

    public void clickSignInButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void clickAddNewPostButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(addNewPostButton)).click();
    }

    public void clickLatestPostButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(latestPostButton)).click();
    } //WE are social media  WE are social media

    public void searchForProfession(String profession) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchForProfessionField)).sendKeys(profession);
    }

    public void searchForName(String name) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchForNameField)).sendKeys(name);
    }

    public void clickSearchButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }
}
