package com.olx.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
@Setter
public abstract class Page {

    @FindBy(css = "#listContainer")
    public WebElement listContainer;

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public Page(WebDriver driver, WebDriverWait webDriverWait) {
        this.webDriver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(driver, this);
    }

    public void scrollTo(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
