package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyReportsTest extends BaseTest {

    @Test(description = "Open Overall Reports")
    public void overallReportsShouldBeOpenedTest() {
        loginPage.open()
                .login();
        boolean overallReportsIsOpened = myReportsPage.overallReportsOpen()
                .overallReportsIsOpened();

        assertTrue(overallReportsIsOpened, "page is not opened");
    }

    @Test(description = "Open Barbell Squat in Overall Reports")
    public void barbellSquatInOverallReportsShouldBeOpenedTest() {
        loginPage.open()
                .login();

        String barbellSquatText = myReportsPage.exerciseProgressOpen()
                .barbellBenchPressIsOpened();

        assertEquals(barbellSquatText, "Barbell Bench Press", "The text doesn't match");
    }

    @Test(description = "Open Neck in Body Progress")
    public void weightInBodyProgressShouldBeOpenedTest() {
        loginPage.open()
                .login();

        String weightText = myReportsPage.bodyProgressOpen()
                .weightInBodyProgressIsOpened();

        assertEquals(weightText, "Body stat progress: weight( lbs):", "The text doesn't match");
    }
}
