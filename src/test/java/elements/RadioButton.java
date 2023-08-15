package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    String RadioLocator = "";
    WebDriver driver;
    String Gender;
    public RadioButton(WebDriver driver, String Gender) {
        this.driver = driver;
        this.Gender = Gender;
    }
    public void selectGender(){
        driver.findElement(By.xpath(String.format(RadioLocator, this.Gender))).click();
    }}