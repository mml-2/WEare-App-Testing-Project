package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BaseWeArePage {
    public RegisterPage() {
        super("register");
    }

    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirm");
    private final By category = By.id("category.id");
    private final By submit = By.xpath("//input[@type='submit']");
    private final By errorMessage=By.xpath("//div/div/i");

    public String getErrorMessage() {
        return driver().findElement(errorMessage).getText();
    }

    public void selectCategory(String categoryName) {
        WebElement categoryElement = driverWait().until(ExpectedConditions.visibilityOfElementLocated(category));

        Select select = new Select(categoryElement);
        select.selectByVisibleText(categoryName);
    }

    public void clickSubmitButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }

    public void inputUsername(String username) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void inputEmail(String email) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void password(String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
    }

    public void fillAllFields(String username, String email, String password, String confirmPassword) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
    }
    public void fillExistingUserDetails() {
        String existingUsername = ""; // Replace with actual username
        String existingEmail = ""; // Replace with actual email
        String existingPassword = ""; // Replace with actual password
        String existingConfirmPassword = ""; // Same as password for confirmation

        fillAllFields(existingUsername, existingEmail, existingPassword, existingConfirmPassword);
    }

}
