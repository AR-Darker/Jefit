package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String textAreaLocator = "";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.textAreaLocator = textAreaLocator;
    }

    public void writeText(String text){
        driver.findElement(By.xpath(String.format(textAreaLocator,this.label))).clear();
        driver.findElement(By.xpath(String.format(textAreaLocator,this.label))).sendKeys(text);
    }
}

