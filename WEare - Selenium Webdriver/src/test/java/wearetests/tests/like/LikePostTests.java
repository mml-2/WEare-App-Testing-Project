package wearetests.tests.like;

import constants.CommentConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LikePostTests extends BaseLike {

    @Test
    @DisplayName("Like Button Test - Ensure Like Count Updates Correctly")
    public void like_Button_Test() {
        String initialLikeCount = feedsPage.getLikeCount();

        feedsPage.clickLikeButton();
        String afterFirstLike = feedsPage.getLikeCount();

        Assertions.assertEquals(initialLikeCount, afterFirstLike, CommentConstants.ERROR_LIKE_NOT_UPDATED);

        feedsPage.clickLikeButton();
        String afterUnlike = feedsPage.getLikeCount();

        Assertions.assertEquals(initialLikeCount, afterUnlike, CommentConstants.ERROR_LIKE_NOT_UPDATED);
    }
}
