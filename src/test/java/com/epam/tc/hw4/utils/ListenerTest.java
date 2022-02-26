package com.epam.tc.hw4.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class ListenerTest implements ITestListener {

    @Step("Hi Listeners")
    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.attachPngImage("Screenshot on failure", screenshot);
        } else {
            Allure.addAttachment("Screenshot on failure", "screenshot");
        }
        result.setEndMillis(System.currentTimeMillis());
    }
}
