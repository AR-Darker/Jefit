package pages;

import elements.ButtonAHref;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CoachModePage extends BasePage {
    public CoachModePage(WebDriver driver) {
        super(driver);
    }

    public static final By COACH_LOGO_FREE_TRIAL = By.xpath("//span[text() ='START 14-DAY FREE TRIAL']");


    @Step("Open Coach mode page")
    public CoachModePage openCoachModePage() {
        new ButtonAHref(driver, "Coach").click();
        return this;
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + COACH_LOGO_FREE_TRIAL);
        return isExist(COACH_LOGO_FREE_TRIAL);
    }

}
