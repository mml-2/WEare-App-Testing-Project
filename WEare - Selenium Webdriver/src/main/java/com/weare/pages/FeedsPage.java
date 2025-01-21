package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class FeedsPage extends BaseWeArePage {
    public FeedsPage() {
        super("/posts");
    }

    private final By likeButton = By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/form/input");
    private final By likeCount = By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/span[3]");

    private final By USERS = By.xpath("//div[@class='text pl-md-4']");
    private final By EXPLORE_BUTTON = By.xpath(".//a[contains(@class,'btn btn-primary') and contains(@href,'/posts')]");

    public void getSpecificUser(int number) {
        List<WebElement> users = driver().findElements(USERS);
        for (int i = 0; i < users.size(); i++) {
            users = driverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(USERS));
            WebElement user = users.get(number);
            WebElement exploreButton = user.findElement(EXPLORE_BUTTON);
            exploreButton.click();
        }
    }

    public void clickLikeButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButton)).click();
    }

    public void clickDislikeButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButton)).click();
    }

    public String getLikeCount() {
        WebElement likeElement = driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeCount));
        return likeElement.getText();
    }
}
