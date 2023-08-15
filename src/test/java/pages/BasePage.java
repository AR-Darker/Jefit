package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String URL = "https://www.jefit.com/";
    public static final By BUTTON_ = By.xpath("");
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }
    public String waitAndGetText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    public void waitAndClick(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    public boolean waitAndIsDisplayedt(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
    public abstract boolean isPageOpen();

    public boolean isExist(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("====>" + e.getMessage());
            return false;
        }
    }
}
