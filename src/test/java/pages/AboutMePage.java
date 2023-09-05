package pages;

import elements.Button;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.AboutMe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AboutMePage extends BasePage {
    public AboutMePage(WebDriver driver) {
        super(driver);
    }
    public static final By ABOUT_ME_TITLE = By.xpath("//strong[text() = 'About Me']");

    @Step("Open About 'Me page'")
    public AboutMePage open() {
        driver.get(BASE_URL + "my-jefit/aboutme/");
        log.info("Open About Me page");
        return this;
    }

    @Step("Create aboutMe")
    public AboutMePage create(AboutMe aboutMe) {
        new Input(driver, "t1").write(aboutMe.getLocation());
        new Input(driver, "t2").write(aboutMe.getOccupation());
        new TextArea(driver, "t3").write(aboutMe.getInterest());
        new TextArea(driver, "t4").write(aboutMe.getWhyDoYouWorkout());
        new TextArea(driver, "t5").write(aboutMe.getHowDidYourStart());
        new TextArea(driver, "t6").write(aboutMe.getWhatMotivatesYou());
        new TextArea(driver, "t7").write(aboutMe.getMainGoal());
        new TextArea(driver, "t8").write(aboutMe.getLongTermGoals());
        new TextArea(driver, "t9").write(aboutMe.getShortTermGoals());
        new TextArea(driver, "t10").write(aboutMe.getMusic());
        new TextArea(driver, "t11").write(aboutMe.getFood());
        new TextArea(driver, "t12").write(aboutMe.getSupplements());
        new TextArea(driver, "t13").write(aboutMe.getExercises());
        new TextArea(driver, "t14").write(aboutMe.getMagazines());
        new TextArea(driver, "t15").write(aboutMe.getMovies());
        log.info("Create " + aboutMe);
        return clickSave();
    }

    @Step("Clear all fields in 'about me'")
    public AboutMePage clearAllFields() {
        new Input(driver, "t1").clear();
        new Input(driver, "t2").clear();
        new TextArea(driver, "t3").clear();
        new TextArea(driver, "t4").clear();
        new TextArea(driver, "t5").clear();
        new TextArea(driver, "t6").clear();
        new TextArea(driver, "t7").clear();
        new TextArea(driver, "t8").clear();
        new TextArea(driver, "t9").clear();
        new TextArea(driver, "t10").clear();
        new TextArea(driver, "t11").clear();
        new TextArea(driver, "t12").clear();
        new TextArea(driver, "t13").clear();
        new TextArea(driver, "t14").clear();
        new TextArea(driver, "t15").clear();
        log.info("Clear all fields in about me and click Save button");
        return clickSave();
    }
    @Step("Click 'Save' button")
    public AboutMePage clickSave() {
        new Button(driver, "Save").click();
        return new AboutMePage(driver);
    }
    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + ABOUT_ME_TITLE);
        return isExist(ABOUT_ME_TITLE);
    }
}