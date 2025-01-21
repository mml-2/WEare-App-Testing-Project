package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BaseWeArePage {
    public ResultsPage() {
        super("/search");
    }

    private final By USERNAMES = By.xpath("//h2[@class='mr-3 text-black']");
    private final By NO_USER_FOUND_MESSAGE = By.xpath("//h3[@class='mb-3 bread']");
    private final By PROFESSION_RESULTS = By.xpath("/html/body/section[1]/div/div/div/div/div[1]/div/div/span");


    public String getProfessions() {
        WebElement profession = driver().findElement(PROFESSION_RESULTS);
        return profession.getText();
    }

    public String getErrorMessage() {
        WebElement message = driver().findElement(NO_USER_FOUND_MESSAGE);
        return message.getText();
    }

    public List<String> getUserNames() {
        driverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(USERNAMES));

        List<WebElement> userElements = driver().findElements(USERNAMES);
        List<String> userNames = new ArrayList<>();

        for (WebElement userElement : userElements) {
            userNames.add(userElement.getText());
        }

        return userNames;
    }

    public boolean isUserPresent(String userName) {
        List<String> userNames = getUserNames();
        return userNames.contains(userName);
    }


}
