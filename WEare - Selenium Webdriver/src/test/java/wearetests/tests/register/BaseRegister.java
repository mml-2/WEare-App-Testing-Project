package wearetests.tests.register;

import org.junit.jupiter.api.BeforeEach;
import wearetests.core.WeAreBaseWeb;


public class BaseRegister extends WeAreBaseWeb {
    @BeforeEach
    public void setUp() {
        homePage.clickRegisterButton();
    }

    public void logout() {
        homePage.clickLogoutButton();
    }
}
