package wearetests.tests.post;

import org.junit.jupiter.api.*;
import static constants.PostConstants.*;

public class CreateAPostTests extends BaseCreateAPost {

    public static final String POST_TEXT = "A new testing post for the WEare social network.";
    public static final String POST_TEXT_B = "Another testing post with a song uploaded.";
    public static final String POST_TEXT_C = "This is a testing post with a song uploaded.";
    public static final String POST_TEXT_D = "This is a testing post with a video uploaded.";
    public static final String POST_TEXT_E = " ";
    public static final String SONG_NAME = "file_example_MP3_700KB.mp3";

    @Test
    @DisplayName("Create a Post Test")
    public void createAPost_Test() {
        createAPostPage.createNewPost(POST_TEXT_A);
        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.clickSavePostButton();
        Assertions.assertTrue(createAPostPage.isPostConfirmationDisplayed(POST_TEXT_A),
                POST_CONTENT_NOT_MATCH);
    }

    @Test
    @DisplayName("Create a Post with Song Upload Less Than 1MB Test")
    public void createAPost_with_song_upload_less_1MB_Test() {
        createAPostPage.createNewPost(POST_TEXT_B);
        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.clickChooseFileButtonSongLessThan1Mb();
        createAPostPage.clickSavePostButton();

        Assertions.assertTrue(createAPostPage.isPostConfirmationDisplayed(POST_TEXT_B),
                POST_CONTENT_NOT_MATCH);
        String postContent = createAPostPage.getSongName();
        Assertions.assertTrue(postContent.contains(SONG_NAME), AUDIO_FILE_NOT_UPLOADED);
    }

   // @Test
    //@DisplayName("Create a Post with Song Upload More Than 1MB Test")
    //public void createAPost_with_song_upload_more_1MB_Test() {
        //createAPostPage.createNewPost(POST_TEXT_C);
        //createAPostPage.selectPostVisibility("Private post");
        //createAPostPage.clickChooseFileButtonSongMoreThan1Mb();
        //createAPostPage.clickSavePostButton();

        //Assertions.assertTrue(createAPostPage.isPostConfirmationDisplayed(POST_TEXT_C),
                //POST_CONTENT_NOT_MATCH);
        //String postContent = createAPostPage.getSongName();
        //Assertions.assertTrue(postContent.contains(SONG_NAME), AUDIO_FILE_NOT_UPLOADED);
    //}

    @Test
    @DisplayName("Create a Post with Video Upload Less Than 1MB Test")
    public void createAPost_with_video_upload_less_1MB_Test() {
        createAPostPage.createNewPost(POST_TEXT_D);
        createAPostPage.selectPostVisibility("Private post");
        createAPostPage.clickChooseFileButtonVideoLessThan1Mb();
        createAPostPage.clickSavePostButton();

        Assertions.assertTrue(createAPostPage.isPostConfirmationDisplayed(POST_TEXT_D),
                POST_CONTENT_NOT_MATCH);
        String postContent = createAPostPage.getSongName();
        Assertions.assertTrue(postContent.contains(VIDEO_NAME), VIDEO_FILE_NOT_UPLOADED);
    }

    @Test
    @DisplayName("Create a Post with No Content Test")
    public void createAPost_with_no_content_Test() {
        createAPostPage.createNewPost(POST_TEXT_E);
        createAPostPage.selectPostVisibility("Public post");
        createAPostPage.clickSavePostButton();

        Assertions.assertTrue(createAPostPage.isPostConfirmationDisplayed(POST_TEXT_E),
                POST_CONTENT_NOT_MATCH);
    }
}
