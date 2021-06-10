package com.olx;

import com.olx.driver.Driver;
import com.olx.listener.LogListener;
import com.olx.pages.component.Footer;
import com.olx.property.EnvironmentProperties;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(LogListener.class)
public class BaseTest {

    private static final String URL = EnvironmentProperties.getProperty("URL");

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        driver = new Driver().initDriver();
        webDriverWait = new Driver().initWebDriverWait(driver);
        driver.get(URL);
    }

    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        driver = new Driver().initDriver();
        webDriverWait = new Driver().initWebDriverWait(driver);
        driver.get(URL);
        Footer footer = new Footer(driver, webDriverWait);
        footer.closeCookieBanner();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.get(URL);
        driver.navigate().refresh();
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
