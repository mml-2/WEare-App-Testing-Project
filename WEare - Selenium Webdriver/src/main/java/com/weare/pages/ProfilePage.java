package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BaseWeArePage {
    public ProfilePage() {
        super("");
    }

    private final By EDIT_BUTTON = By.xpath("//a[contains(text(),'edit')]");
    private final By FIRST_NAME_FIELD = By.id("nameE");
    private final By LAST_NAME_FIELD = By.id("lastnameE");
    private final By BIRTHDAY_FIELD = By.id("birthDayE");
    private final By SUBMIT_BUTTON = By.xpath("//button[@name='submit']");
    private final By PROFILE_BUTTON = By.id("list-front-list");
    private final By WELCOME_NAME = By.xpath("//h1");
    private final By PERSONAL_INFO = By.id("home");
    private final By EMAIL_FIELD = By.id("emailE");
    private final By DROP_FEW_WORDS_FIELD = By.id("publicinfoE");
    private final By ERROR_MESSAGE=By.xpath("//i");

    public String getErrorMessage(){
        WebElement message=driver().findElement(ERROR_MESSAGE);
        return message.getText();
    }

    public void updateEmail(String email) {
        clearAndType(EMAIL_FIELD, email);
    }

    private void clearAndType(By locator, String value) {
        WebElement element = driverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void addAFewWordsAboutYourself(String description) {
        clearAndType(DROP_FEW_WORDS_FIELD, description);
    }

    public String getInfo() {
        WebElement info = driver().findElement(PERSONAL_INFO);
        return info.getText();
    }

    public String getName() {
        WebElement name = driver().findElement(WELCOME_NAME);
        return name.getText();
    }

    public void clickProfileButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(PROFILE_BUTTON)).click();
    }

    public void clickUpdateButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_BUTTON)).click();
    }

    public void updateFirstName(String firstName) {
        clearAndType(FIRST_NAME_FIELD, firstName);
    }

    public void updateBirthday(String birthday) {
        clearAndType(BIRTHDAY_FIELD, birthday);
    }

    public void updateLastName(String lastname) {
        clearAndType(LAST_NAME_FIELD, lastname);

    }


    public void clickEditButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(EDIT_BUTTON)).click();
    }
}
