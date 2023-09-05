package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileHomeTest extends BaseTest {

    @Test(description = "Upload Profile Picture")
    public void photoShoutBeUploadedTest() {
        loginPage.open()
                .login();

        profileHomePage.uploadProfilePic();

        String imageName = profileHomePage.fileIsUploaded();
        assertTrue(imageName.contains("avatar"), "Picture not uploaded");
    }

    @Test(description = "Change status ")
    public void statusShouldBeChangedTest(){
        loginPage.open()
                .login();
        profileHomePage.changeStatus();

        assertEquals(profileHomePage.getStatusText(), "Status : " + profileHomePage.returnFakerText(), "The text doesn't match");
    }

    @Test(description = "Delete status")
    public void statusShouldBeDeletedTest(){
        loginPage.open()
                .login();
        profileHomePage.deleteStatus();

        assertEquals(profileHomePage.getStatusText(), "Status", "Status is not deleted");
    }

    @Test(description = "Sign out")
    public void signOutTest() {
        loginPage.open()
                .login();
        profileHomePage.signOut();

        assertTrue(loginPage.isPageOpen(), "Login page hasn't opened");
    }

}