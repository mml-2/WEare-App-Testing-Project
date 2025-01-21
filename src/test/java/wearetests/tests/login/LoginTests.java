package wearetests.tests.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.LoginConstants.*;
import static wearetests.testdata.Users.*;


public class LoginTests extends BaseLogin {

    @Test
    @DisplayName("Login with Valid Credentials")
    public void login_whenValidCredentials_AreInput() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        Assertions.assertEquals(getHeaderText(), SUCCESS_HEADER_TEXT, ERROR_LOGIN_FAILED);
    }

    @Test
    @DisplayName("Login with Invalid Credentials")
    public void login_whenInvalidCredentials_AreInput() {
        loginPage.inputCredentials(INVALID_USER, INVALID_PASSOWRD);
        Assertions.assertEquals(getErrorMessageText(), ERROR_MESSAGE_TEXT, ERROR_MESSAGE_NOT_EXPECTED);
    }

    @Test
    @DisplayName("Login with Blank Credentials")
    public void login_whenBlankCredentials_AreInput() {
        loginPage.inputCredentials("", "");
        Assertions.assertEquals(getErrorMessageText(), ERROR_MESSAGE_TEXT, ERROR_MESSAGE_NOT_EXPECTED);
    }

    @Test
    @DisplayName("Logged in as User - Admin Panel Not Visible")
    public void loggedIn_asUser_AdminPanelNotVisible() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        By adminPanelButtonLocator = By.xpath("//a[@href='/admin']");
        boolean isAdminPanelVisible = isElementVisible(adminPanelButtonLocator);
        Assertions.assertFalse(isAdminPanelVisible, INFO_ADMIN_PANEL_NOT_VISIBLE);
    }

    @Test
    @DisplayName("Logged in as Admin - Admin Panel Visible")
    public void loggedIn_asAdmin_AdminPanelVisible() {
        loginPage.inputCredentials(ADMIN_USER, ADMIN_PASSWORD);
        By adminPanelButtonLocator = By.xpath("//a[@href='/admin']");
        boolean isAdminPanelVisible = isElementVisible(adminPanelButtonLocator);
        Assertions.assertTrue(isAdminPanelVisible, INFO_ADMIN_PANEL_VISIBLE);
    }

    @Test
    @DisplayName("Logout Test")
    public void logout_Test() {
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickLogoutButton();
        By registerButton = homePage.getRegisterButtonLocator();
        Assertions.assertTrue(
                driverWait().until(ExpectedConditions.invisibilityOfElementLocated(registerButton)),
                "Register button is still visible, logout might have failed"
        );
        Assertions.assertEquals(loginPage.getLoginText(), "Login Page", ERROR_LOGOUT_FAILED);
    }
}

