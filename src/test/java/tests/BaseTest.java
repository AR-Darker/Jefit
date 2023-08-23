package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import pages.LoginPage;
import pages.ProfileHomePage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\filesForDownload";
    String nameDownloadedFile;
    int wait = 15000;
    boolean fileIsNotReady = true;
    public LoginPage loginPage;
    public ProfileHomePage profileHomePage;
    @BeforeMethod
    public void setUp(ITestContext context){
        /////////
        //todo У тебя работа с браузеро файрфокс, проверяй для гугла потиху
        WebDriverManager.firefoxdriver().setup();
        HashMap<String, Object> firefoxPrefs = new HashMap<String, Object>();
        firefoxPrefs.put("profile.default_content_settings.popups", 0);
        firefoxPrefs.put("download.prompt_for_download", "false");
        firefoxPrefs.put("download.default_directory", downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", firefoxPrefs);
        options.addArguments("--window-size=1920,1080");
        ///////
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);

//todo (не забудь инициализировать страницы)
        loginPage = new LoginPage(driver);
        profileHomePage = new ProfileHomePage(driver);
}
    public void downloader(String fileLocator, String nameDownloadedFile) throws IOException, InterruptedException {
        WebElement ourFile = driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(downloadPath));
        File folder = new File(downloadPath);
        File[] listOfFiles = folder.listFiles();

        ourFile.click();

        while (wait != 0 && fileIsNotReady){
            listOfFiles =  folder.listFiles();
            Thread.sleep(100);
            wait-=100;
            if ((listOfFiles.length !=0 && listOfFiles[0].getName().equals(nameDownloadedFile))){
                fileIsNotReady = false;
            }
        }
        assertEquals(listOfFiles[0].getName(), nameDownloadedFile);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }}

