package wearetests.tests.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.CommentConstants.ERROR_COMMENT_NOT_DELETED;
import static constants.CommentConstants.SUCCESS_COMMENT_DELETED;

public class CommentTests extends BaseComment{

    String comment = "Prowerka";
    String longText = "testtesttesttesttesttesttesttest ";
    String longComment = longText.repeat(66);

    @Test
    @DisplayName("Create a Comment - Ensure Comment is Posted Successfully")
    public void createAComment_Test() {
        commentPage.createNewComment(comment);
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();
        Assertions.assertTrue(commentPage.isCommentConfirmationDisplayed(comment),
                ERROR_COMMENT_NOT_DELETED);
    }

    @Test
    @DisplayName("Comment on Specific User - Ensure Comment is Displayed Correctly")
    public void comment_on_specificUser_Test() {
        feedsPage.getSpecificUser(2);
        commentPage.createNewComment("asdadasdsa");
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();
        Assertions.assertTrue(commentPage.isCommentConfirmationDisplayed("asdadasdsa"),
                ERROR_COMMENT_NOT_DELETED);
    }

    @Test
    @DisplayName("Delete a Comment - Ensure Comment is Deleted Successfully")
    public void deleteAComment_Test() {
        deleteComment();
        Assertions.assertEquals(commentPage.getDeleteMesaggeText(),
                SUCCESS_COMMENT_DELETED,
                "Comment is not deleted.");
    }

    @Test
    @DisplayName("Create a Comment with Long Message - Ensure Long Comment is Posted Correctly")
    public void createAComment_with_long_message_Test() {
        commentPage.createNewComment(longComment);
        commentPage.clickPostCommentButton();
        commentPage.clickShowCommentsButton();
        Assertions.assertEquals(
                longComment.trim(),
                commentPage.getCommentText(longComment).trim(),
                "The posted comment does not match the expected value."
        );
    }
}
