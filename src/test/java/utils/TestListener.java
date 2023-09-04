package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;
@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST START: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test success: %s \n", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenShot(driver);
        log.info(">>>>>>>>>>>>>>>>>>>TEST FAIL: " +result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf("Test skipped: %s \n", result.getName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info(String.format("TEST %s FAILED WITH TIMEOUT", result.getName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("TEST FINISH");
    }
}