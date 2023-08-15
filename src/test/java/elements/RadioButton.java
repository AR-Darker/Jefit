package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    String radioLocator = "";
    WebDriver driver;
    String gender;
    public RadioButton(WebDriver driver, String gender) {
        this.driver = driver;
        this.gender = gender;
    }
    public void selectGender(){
        driver.findElement(By.xpath(String.format(radioLocator, this.gender))).click();
    }}