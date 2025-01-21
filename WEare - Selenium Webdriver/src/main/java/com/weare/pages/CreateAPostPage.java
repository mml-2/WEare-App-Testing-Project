package com.weare.pages;

import org.apache.groovy.parser.antlr4.GroovyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



public class CreateAPostPage extends BaseWeArePage{
    public CreateAPostPage() {
     super("/posts/auth/newPost");
}


private final By postVisibilityDropdown = By.id("StringListId");
private final By postContentBox = By.id("message");
private final By savePostButton = By.xpath("//input[@value='Save post']");
private final By songConfirmationText = By.xpath("//p[text()='file_example_MP3_700KB.mp3']");
private final By chooseFileButton = By.xpath("//*[@id=\"imagefile\"]");
private final String postConfirmationText = "//p[text()='%s']";


    public By getPostConfirmationText(String topic) {
        String dynamicXPath = String.format(postConfirmationText, topic);
        return By.xpath(dynamicXPath);
    }
    public boolean isPostConfirmationDisplayed(String postText) {
        WebElement confirmationElement = driverWait().until(
                ExpectedConditions.visibilityOfElementLocated(getPostConfirmationText(postText)));
        return confirmationElement.getText().contains(postText);
    }

    public void selectPostVisibility(String postVisibility) {
        WebElement visibilityOption = driverWait().until(ExpectedConditions.visibilityOfElementLocated(postVisibilityDropdown));

        Select select = new Select(visibilityOption);
        select.selectByVisibleText(postVisibility);
    }

    public void createNewPost(String postContent) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(postContentBox)).sendKeys(postContent);
    }

    public void clickSavePostButton() {
    driverWait().until(ExpectedConditions.visibilityOfElementLocated(savePostButton)).click();
    }

    public void clickChooseFileButtonSongLessThan1Mb() {
        WebElement until = driverWait().until(ExpectedConditions.visibilityOfElementLocated(chooseFileButton));
        String filePath = "";
        until.sendKeys(filePath);
    }

    //public void clickChooseFileButtonSongMoreThan1Mb() {
        //WebElement until = driverWait().until(ExpectedConditions.visibilityOfElementLocated(chooseFileButton));
        //String filePath = "";
        //until.sendKeys(filePath);
    //}

    public void clickChooseFileButtonVideoLessThan1Mb() {
        WebElement until = driverWait().until(ExpectedConditions.visibilityOfElementLocated(chooseFileButton));
        String filePath = "";
        until.sendKeys(filePath);
    }

    public void addNewPost(String postContent) {
    createNewPost(postContent);
    }

    public String getSongName() {
        WebElement postText = driverWait().until(ExpectedConditions.visibilityOfElementLocated(songConfirmationText));
        return postText.getText();
    }
}
