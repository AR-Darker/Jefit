package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    WebDriver driver;
    String pathToDownload = System.getProperty("user.dir") + "";
    String nameDownloadedFile;
    int wait = 15000;
    boolean fileIsNotReady = true;
    public LoginPage loginPage;
    @BeforeMethod
    public void setUp(ITestContext context){
        WebDriverManager.chromedriver().setup();
        /////////
        ChromeOptions options = new ChromeOptions();
        HashMap<String,Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", pathToDownload);
        options.setExperimentalOption("prefs",chromePrefs);
        ///////
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);

//todo (не забудь инициализировать страницы)
        loginPage = new LoginPage(driver);
}
    public void downloader(String fileLocator, String nameDownloadedFile) throws IOException, InterruptedException {
        WebElement ourFile = driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(pathToDownload));
        File folder = new File(pathToDownload);
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
    public void workWithAlert(){
        Alert alert1 = new Alert() {
            @Override
            public void dismiss() {

            }

            @Override
            public void accept() {

            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public void sendKeys(String s) {

            }
        };
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }}

