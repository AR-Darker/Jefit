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
}
