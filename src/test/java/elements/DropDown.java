package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class DropDown {
    String dropDownLocator = "";
    String optionLocator = "";

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option){
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label))).click();
        log.info("Click on DropDown with label" + this.label);
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        log.info("Select Option" + option);



    }
}