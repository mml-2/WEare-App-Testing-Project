package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CommentPage extends BaseWeArePage{

    public CommentPage() {
        super("/api/comment/auth/creator");
    }

    private final By exploreThisPostButton = By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[3]/a[1]");
    private final By commentField = By.id("message");
    private final By postCommentButton = By.xpath("//input[@value='Post Comment']");
    private final String commentConfirmationText = "//p[text()='%s']";
    private final By showCommentsButton = By.cssSelector("button.show-comments");
    private final By deleteCommentButton = By.xpath("//*[@id=\"comments\"]/div[2]/p[2]/a[2]");
    private final By deleteOptionDropdown = By.id("StringListId");
    private final By submitButtonLocator = By.xpath("//input[@value='Submit']");
    private final By deleteMessageConfirmation = By.xpath("//h1");
    private final By editCommentButton = By.xpath("//*[@id=\"comments\"]/div[2]/p[2]/a[1]");

    public boolean isCommentConfirmationDisplayed(String postText) {
        WebElement confirmationElement = driverWait().until(
                ExpectedConditions.visibilityOfElementLocated(getCommentConfirmationText(postText)));
        return confirmationElement.getText().contains(postText);
    }

    public By getCommentConfirmationText(String comment) {
        String dynamicXPath = String.format(commentConfirmationText, comment);
        return By.xpath(dynamicXPath);
    }

    public void clickExploreThisPostButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(exploreThisPostButton)).click();
    }

    public void clickShowCommentsButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(showCommentsButton));
        driver().scrollToElement(showCommentsButton);
        driver().findElement(showCommentsButton).click();
    }

    public void clickDeleteCommentsButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteCommentButton)).click();
    }

    public void clickEditCommentButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(editCommentButton)).click();
    }

    public void selectDeleteOption(String deleteOption) {
        WebElement deleteOptionMenu = driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteOptionDropdown));

        Select select = new Select(deleteOptionMenu);
        select.selectByVisibleText(deleteOption);
    }

    public void clickSubmitButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator)).click();
    }

    public void createNewComment(String commentContent) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(commentField)).sendKeys(commentContent);
    }

    public void clickPostCommentButton() {
        WebElement button = driver().findElement(postCommentButton);
        if (!button.isDisplayed()) {
            System.out.println("Button is not visible.");
            return;
        }
        driverWait().until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public void addNewComment(String commentContent) {

        createNewComment(commentContent);
    }

    public String getCommentText(String comment) {
        WebElement element = driverWait().until(ExpectedConditions.visibilityOfElementLocated(getCommentConfirmationText(comment)));
        return element.getText();
    }

    public String getDeleteMesaggeText() {
        return driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteMessageConfirmation)).getText();
    }
}
