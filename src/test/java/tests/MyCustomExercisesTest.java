package tests;

import models.CustomExercise;
import models.CustomExerciseFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyCustomExercisesTest extends BaseTest {

    @Test(description = "Open My Custom Exercise")
    public void myCustomExerciseShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercisesPage
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

    }

    @Test(description = "Create new Custom Exercise")
    public void newCustomExerciseShouldBeCreatedTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercisesPage
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

        CustomExercise customExercise = CustomExerciseFactory.get();

        myCustomExercisesPage
                .createNewCustomExercise(customExercise);
        boolean isMyEditedExercisePageOpened = myCustomExercisesPage
                .isPageOpen();

        assertTrue(isMyEditedExercisePageOpened, "New Custom Exercise hasn't created");
        assertEquals(myCustomExercisesPage.getCreatedExerciseName(), customExercise.getExerciseName(), "Name of the Exercise doesn't match");
        myCustomExercisesPage
                .clickDelete();
    }
    @Test(description = "Delete Custom Exercise")
    public void customExerciseShouldBeDeletedTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercisesPage
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

        CustomExercise customExercise = CustomExerciseFactory.get();

        myCustomExercisesPage
                .createNewCustomExercise(customExercise)
                .clickDelete();
        assertEquals(myCustomExercisesPage.getEmptyExercisesList(), "", "Exercise hasn't deleted");
    }

}
