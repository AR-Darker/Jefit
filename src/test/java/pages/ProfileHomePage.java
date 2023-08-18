package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProfileHomePage extends BasePage {
    Faker faker = new Faker();
    String text = faker.animal().name();
    public static final By PROFILE_PIC = By.xpath("//img[@class ='leftProfilePic']");

    public ProfileHomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Delete status")
    public void deleteStatus() {
        new Button(driver, "Post").click();
        log.info("Delete status");
    }
    @Step("Edit status")
    public void changeStatus() {
        new TextArea(driver, "statusinputbox").write(text);
        new Button(driver, "Post").click();
        log.info("Change status");
    }
    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + PROFILE_PIC);
        return isExist(PROFILE_PIC);
    }

}