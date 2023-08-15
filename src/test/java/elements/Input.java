package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class Input {
    String inputLocator = "";
    String inputLocatorForContact = "";
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public void write(String text){
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).clear();
        log.info("Clear Input With Label" +this.label );
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
        log.info("Write into input this label" + this.label + "text" + text );
    }
    public void writeContact(String text){
        driver.findElement(By.xpath(String.format(inputLocatorForContact, this.label))).clear();
        driver.findElement(By.xpath(String.format(inputLocatorForContact, this.label))).sendKeys(text);
    }
    }

