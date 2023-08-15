package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    String checkBoLocator = "";
    WebDriver driver;
    String variable;

    public CheckBox(WebDriver driver, String variable) {
        this.driver = driver;
        this.variable = variable;

    }
    public void select(){
        driver.findElement(By.xpath(String.format(checkBoLocator, this.variable))).click();
    }}