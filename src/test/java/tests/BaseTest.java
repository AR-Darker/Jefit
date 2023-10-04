package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    int wait = 15000;

    protected LoginPage loginPage;
    protected ProfileHomePage profileHomePage;
    protected AboutMePage aboutMePage;
    protected UserPage userPage;
    protected RoutinesPage routinesPage;
    protected CoachModePage coachModePage;
    protected FriendsPage friendsPage;
    protected LogWorkoutPage logWorkoutPage;
    protected MyCustomExercisesPage myCustomExercisesPage;
    protected MyReportsPage myReportsPage;
    @BeforeMethod(description = "setUpBrowserParameters")
    public void setUp(ITestContext context){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);


        loginPage = new LoginPage(driver);
        profileHomePage = new ProfileHomePage(driver);
        aboutMePage = new AboutMePage(driver);
        userPage = new UserPage(driver);
        routinesPage = new RoutinesPage(driver);
        coachModePage = new CoachModePage(driver);
        friendsPage = new FriendsPage(driver);
        logWorkoutPage = new LogWorkoutPage(driver);
        myCustomExercisesPage = new MyCustomExercisesPage(driver);
        myReportsPage = new MyReportsPage(driver);
}


    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }}

