package com.olx.driver;

import java.util.concurrent.TimeUnit;

import com.olx.property.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.olx.driver.Browser.FIREFOX;

public class Driver {

    private static final String BROWSER_HEIGHT = EnvironmentProperties.getProperty("browser.height");
    private static final String BROWSER_WIDTH = EnvironmentProperties.getProperty("browser.width");
    private static final Browser BROWSER = Browser.valueOf(EnvironmentProperties.getProperty("browser"));
    private static final long IMPLICITLY_TIMEOUT = Long.parseLong(EnvironmentProperties.getProperty("implicitly.timeout"));
    private static final long PAGE_LOAD_TIMEOUT = Long.parseLong(EnvironmentProperties.getProperty("implicitly.timeout.pageLoad"));
    private static final long SCRIPT_TIMEOUT = Long.parseLong(EnvironmentProperties.getProperty("implicitly.timeout.script"));
    private static final long EXPLICITLY_TIMEOUT = Long.parseLong(EnvironmentProperties.getProperty("explicitly.timeout"));

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriver initDriver() {
        if (webDriver == null) {
            if (BROWSER == FIREFOX) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                webDriver = new ChromeDriver(options);
            }
        }
        webDriver.manage().window().setSize(new Dimension(Integer.parseInt(BROWSER_WIDTH), Integer.parseInt(BROWSER_HEIGHT)));
        webDriver.manage().timeouts().implicitlyWait(IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        return webDriver;
    }

    public WebDriverWait initWebDriverWait(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, EXPLICITLY_TIMEOUT);
        return webDriverWait;
    }


}
