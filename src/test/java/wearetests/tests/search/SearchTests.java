package wearetests.tests.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.SearchConstants.*;
import static constants.SearchConstants.NO_ERROR_MESSAGE_FOR_UNEXISTING_USER;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wearetests.testdata.Users.*;

public class SearchTests extends BaseSearch {

    private String nonExistingUser = "unex user";
    String doctorProfession = "Doctor";

    @Test
    @DisplayName("Search for Profession Test")
    public void search_for_profession_Test() {
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        searchForProfession(doctorProfession);
        clickSearchButton();
        Assertions.assertEquals(resultsPage.getProfessions(),
                doctorProfession,
                ERROR_WRONG_PROFESSION);
    }

    @Test
    @DisplayName("Search for Logged-In User Test")
    public void search_for_LoggedInUser_Test() {
        getUsername();
        searchForName(loggedInUsername);
        clickSearchButton();
        assertTrue(resultsPage.isUserPresent(loggedInUsername),
                CURRENT_USER_NOT_FOUND);
    }

    @Test
    @DisplayName("Search for Not Found User Test")
    public void search_for_not_found_user_Test() {
        searchForName(nonExistingUser);
        clickSearchButton();
        Assertions.assertEquals(resultsPage.getErrorMessage(),
                NO_ERROR_MESSAGE_USER_NOT_FOUND,
                NO_ERROR_MESSAGE_FOR_UNEXISTING_USER);
    }
}
