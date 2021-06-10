package com.olx.pages.component;

import com.olx.pages.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class Footer extends Page {

    @FindBy(css = "#cookiesBar")
    WebElement cookieFooter;

    @FindBy(css = ".cookiesBarClose.abs")
    WebElement cookieButton;

    public Footer(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void closeCookieBanner() {
        webDriverWait.until(elementToBeClickable(cookieButton));
        cookieButton.click();
        webDriverWait.until(not(visibilityOf(cookieFooter)));
    }
}
