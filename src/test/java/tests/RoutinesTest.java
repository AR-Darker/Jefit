package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RoutinesTest extends BaseTest {

    @Test(description = "Create Routine")
    public void routineShouldBeCreatedTest() {
        loginPage.open()
                .login();

       routinesPage.open()
               .createRoutine()
               .isPageOpen();

        assertTrue(routinesPage.isPageOpen(), "Page is not opened");

        assertEquals(routinesPage.getRoutineName(), routinesPage.returnRoutineFakerText(), "The text doesn't match");

        routinesPage.deleteRoutine();
    }


    @Test(description = "Delete Routine")
    public void routineShouldBeDeletedTest() {
        loginPage.open()
                .login();
        routinesPage.open()
                .createRoutine()
                .deleteRoutine();

        assertEquals(routinesPage.routineIsDeletedText(),
                "You have not setup a default routine yet. Please create one or set one as default routine"
        , "The text doesn't match");

    }
}
