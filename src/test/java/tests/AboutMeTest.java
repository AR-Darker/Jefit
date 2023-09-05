package tests;

import models.AboutMe;
import models.AboutMeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class AboutMeTest extends BaseTest {

    @Test(description = "Create About Me")
    public void aboutMeShouldBeCreatedTest() {
        loginPage.open()
                .login();

        AboutMe aboutMe = AboutMeFactory.get();
        aboutMePage.open()
                .create(aboutMe);

        boolean isUserPageOpened = userPage
                .open()
                .isPageOpen();

        assertTrue(isUserPageOpened, "User page hasn't opened");

        assertEquals(userPage.getFieldValue("Occupation"), aboutMe.getOccupation(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Main Goal"), aboutMe.getMainGoal(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Why Do You Workout"), aboutMe.getWhyDoYouWorkout(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("What Motivates You"), aboutMe.getWhatMotivatesYou(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("How Did Your Start"), aboutMe.getHowDidYourStart(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Short Term Goals"), aboutMe.getShortTermGoals(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Long Term Goals"), aboutMe.getLongTermGoals(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Exercises"), aboutMe.getExercises(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Supplements"), aboutMe.getSupplements(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Interest"), aboutMe.getInterest(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Food"), aboutMe.getFood(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Music"), aboutMe.getMusic(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Movies"), aboutMe.getMovies(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Magazines"), aboutMe.getMagazines(), "The text doesn't match");

        aboutMePage.open()
                .clearAllFields();

    }
}
