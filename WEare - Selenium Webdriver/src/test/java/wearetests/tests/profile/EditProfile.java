package wearetests.tests.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.ProfileConstants.*;

public class EditProfile extends BaseEdit {

    private String updatedFirstName = "name";
    private String updatedLastName = "lastname";
    private String month = "01";
    private String day = "06";
    private String year = "1998";
    private String fullName = updatedFirstName + " " + updatedLastName;
    private String dayToCheck = year + "-" + day + "-" + month;
    private String updatedEmail = "newMail@ab21wfsa8c.test";
    private String bio = "I like to go for a long walks";

    @Test
    @DisplayName("Update First Name, Last Name, and Birthday Test")
    public void update_FirstName_LastName_BirthDay_Test() {
        updateProfile(updatedFirstName, updatedLastName, day + month + year);
        Assertions.assertEquals(profilePage.getName(), fullName, NAME_NOT_UPDATED);
        Assertions.assertTrue(profilePage.getInfo().contains(updatedFirstName), FIRST_NAME_NOT_UPDATED);
        Assertions.assertTrue(profilePage.getInfo().contains(updatedLastName), LAST_NAME_NOT_UPDATED);
        Assertions.assertTrue(profilePage.getInfo().contains(dayToCheck), BIRTHDAY_NOT_UPDATED);
    }

    @Test
    @DisplayName("Update Email Test")
    public void update_Email_Test() {
        updateEmail(updatedEmail);
        Assertions.assertTrue(profilePage.getInfo().contains(updatedLastName), EMAIL_NOT_UPDATED);
    }

    @Test
    @DisplayName("Update Birthday Test")
    public void update_Birthday_Test() {
        updateBirthDate("10/11/2010");
        Assertions.assertTrue(profilePage.getInfo().contains("2010-10-11"), BIRTHDAY_NOT_UPDATED);
    }

    @Test
    @DisplayName("Add a Few Words About Yourself Test")
    public void add_aFew_Words_About_Yourself() {
        profilePage.addAFewWordsAboutYourself(bio);
        profilePage.clickUpdateButton();
        profilePage.clickProfileButton();
        Assertions.assertTrue(profilePage.getInfo().contains(bio), BIO_NOT_UPDATED);
    }

    @Test
    @DisplayName("First Name Blank Test")
    public void firstName_Blank_Test() {
        updateFirstName("");
        Assertions.assertEquals(profilePage.getErrorMessage(),
                ERROR_MESSAGE_FIRST_NAME,
                NO_ERROR_FOR_BLANK_FIRST_NAME);
    }
}
