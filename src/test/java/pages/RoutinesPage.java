package pages;

import com.github.javafaker.Faker;
import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RoutinesPage extends BasePage {
    public RoutinesPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();
    String text = faker.cat().name();

    public static final By DOWNLOAD_A_ROUTINE_BUTTON = By.xpath("//a[text()='Download A Routine']");
    public static final By ROUTINE_NAME = By.xpath("descendant::a[@class ='confirmText'][1]/strong");
    public static final By DELETE_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText']/img[@src= '../../../images/delete_icon1.png']");

    public static final By COUNT_ROUTINE = By.xpath("//td[normalize-space()='0/20 Routines Created']");


    @Step("Open Routine page")
    public RoutinesPage open() {
        driver.get(BASE_URL + "/my-jefit/my-routines/routine-manager.php");
        log.info("Open routine page by URL");
        return this;
    }

    @Step("Create Routine")
    public RoutinesPage createRoutine() {
        new ButtonAHref(driver, "Create New Routine").click();
        new Input(driver, "rpname").write(text);
        new Select(driver, "daytype").selectRandomOption();
        new Select(driver, "typeselect").selectRandomOption();
        new Select(driver, "levelselect").selectRandomOption();
        new TextArea(driver, "rptext").write(faker.chuckNorris().fact());
        new TextArea(driver, "rtags").write(faker.cat().name());
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        log.info("JS click on Save button");
        return this;
    }

    @Step("Get routine name")
    public String getRoutineName() {
        log.info("Get routine name by " + ROUTINE_NAME);
        return driver.findElement(ROUTINE_NAME).getText();
    }

    @Step("Get faker text")
    public String returnRoutineFakerText() {
        log.info("Get faker text : " + text);
        return text;
    }

    @Step("Delete routine")
    public RoutinesPage deleteRoutine() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_ROUTINE_BUTTON));
        driver.findElement(DELETE_ROUTINE_BUTTON).click();
        log.info("Click delete routine button by " + DELETE_ROUTINE_BUTTON);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        log.info("Switch to alert and accept");
        wait.until(ExpectedConditions.visibilityOfElementLocated(COUNT_ROUTINE));
        return this;
    }

    @Override
    @Step("Make sure page is opened")
    public boolean isPageOpen() {
        log.info("Find element --> " + DOWNLOAD_A_ROUTINE_BUTTON);
        return isExist(DOWNLOAD_A_ROUTINE_BUTTON);
    }

}
