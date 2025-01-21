package wearetests.tests.comment;

import com.weare.pages.CommentPage;
import com.weare.pages.CreateAPostPage;
import com.weare.pages.FeedsPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import testframework.PropertiesManager;
import wearetests.core.WeAreBaseWeb;

import static wearetests.testdata.Users.*;

public class BaseComment extends WeAreBaseWeb {
    protected CommentPage commentPage;
    protected FeedsPage feedsPage;

    @BeforeEach
    public void setUp() {
        feedsPage = new FeedsPage();
        commentPage = new CommentPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl"));
        homePage.clickSignInButton();
        loginPage.inputCredentials(VALID_USER, VALID_PASSWORD);
        homePage.clickLatestPostButton();
        commentPage.clickExploreThisPostButton();
    }

    public void createComment(String comment) {
        commentPage.createNewComment(comment);
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();

        driver().findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[1]/div/div[2]/p[3]/a[1]")).click();

    }
    public void deleteComment(){
        commentPage.clickShowCommentsButton();
        commentPage.clickDeleteCommentsButton();
        commentPage.selectDeleteOption("Delete comment");
        commentPage.clickSubmitButton();
    }
}
