package tests;

import models.CustomExercise;
import models.CustomExerciseFactory;
import org.testng.annotations.Test;
import models.MyStatus;
import models.MyStatusFactory;
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
        MyStatus myStatus = MyStatusFactory.get();
        profileHomePage.changeStatus(myStatus);

        assertEquals(profileHomePage.getStatusText(), profileHomePage.returnFakerText(), "The text doesn't match");
    }

    @Test(description = "Sign out")
    public void signOutTest() {
        loginPage.open()
                .login();
        profileHomePage.signOut();

        assertTrue(loginPage.isPageOpen(), "Login page hasn't opened");
    }

}