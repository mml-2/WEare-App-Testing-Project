package wearetests.tests.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static wearetests.testdata.Users.*;
import static wearetests.testdata.Users.RANDOM_PASSWORD;
import static constants.RegisterConstants.*;

public class RegisterTests extends BaseRegister {

    @Test
    @DisplayName("Valid Registration Test")
    public void valid_Registration_Test() {
        registerPage.fillAllFields(RANDOM_USERNAME, VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", ERROR_REGISTERING);
    }

    @Test
    @DisplayName("Already Existing User Test")
    public void already_Existing_User_Test() {
        registerPage.fillExistingUserDetails();
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                EXISTING_USER_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_EXISTING_USER);
    }

    @Test
    @DisplayName("Passwords Not Matching Test")
    public void passwords_Not_Matching_Test() {
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, VALID_PASSWORD, "56782Wf");
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                PASSWORD_NOT_CONFIRMED_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_UNMATCHING_PASSWORDS);
    }

    @Test
    @DisplayName("Invalid Email Test")
    public void invalid_Email_Test() {
        registerPage.fillAllFields(RANDOM_USERNAME, INVALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                INVALID_EMAIL_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_EMAIL);
    }

    @Test
    @DisplayName("Username Less Than 2 Symbols Test")
    public void username_less_than_2_symbols_Test() {
        registerPage.fillAllFields(ONE_SYMBOL_USER, VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                USERNAME_LENGTH_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_USERNAME);
    }

    @Test
    @DisplayName("Username More Than 20 Symbols Test")
    public void username_more_than_20_symbols_Test() {
        registerPage.fillAllFields(TWENTY_SYMBOLS_USER, VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                USERNAME_LENGTH_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_USERNAME);
    }

    @Test
    @DisplayName("Password Less Than 8 Symbols Test")
    public void password_less_than_8_symbols_Test() {
        registerPage.fillAllFields(VALID_USER_B, VALID_EMAIL,
                LESS_THAN_EIGHT_SYMBOLS_PASSOWRD,
                LESS_THAN_EIGHT_SYMBOLS_PASSOWRD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                PASSWORD_LENGTH_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Password Without Capital Letter Test")
    public void password_without_capital_letter_Test() {
        registerPage.fillAllFields(VALID_USER_C,
                VALID_EMAIL, NO_CAPITAL_LETTER_PASSWORD,
                NO_CAPITAL_LETTER_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                PASSWORD_CAPITAL_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Password Without Digit Test")
    public void password_without_digit_Test() {
        registerPage.fillAllFields(VALID_USER_D, VALID_EMAIL, NO_DIGIT_PASSWORD, NO_DIGIT_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                PASSWORD_DIGIT_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Password Without Special Symbol Test")
    public void password_without_special_symbol_Test() {
        registerPage.fillAllFields(VALID_USER_E, VALID_EMAIL,
                NO_SPECIAL_SYMBOL_PASSWORD, NO_SPECIAL_SYMBOL_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                PASSWORD_SYMBOL_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Valid Registration for Admin Test")
    public void valid_Registration_Admin_Test() {
        registerPage.fillAllFields(ADMIN_USER, RANDOM_EMAIL, ADMIN_PASSWORD, ADMIN_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(driver().getTitle(), "Successful Registration", ERROR_REGISTERING);
    }

    @Test
    @DisplayName("Random Username Test")
    public void Random_Username_Test() {
        registerPage.fillAllFields(RANDOM_USERNAME, RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
    }

    @Test
    @DisplayName("Register with Whitespace in Username Test")
    public void Register_With_WhiteSpace_Username_Test() {
        registerPage.fillAllFields(RANDOM_USERNAME + " " + VALID_PASSWORD,
                RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_PASSWORD);
        registerPage.selectCategory("Doctor");
        registerPage.clickSubmitButton();
        Assertions.assertEquals(registerPage.getErrorMessage(),
                WHITESPACE_IN_USERNAME_ERROR,
                ASSERTION_ERROR_MESSAGE_FOR_WHITESPACE_IN_USERNAME);
    }
}
