package com.olx.pages.component.filters;

import java.util.List;

import com.olx.pages.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@Slf4j
public class PriceFilter extends Page {

    @FindBy(css = ".numeric-item.price .button")
    private List<WebElement> pricesListButton;

    @FindBy(css = ".numeric-item.price label input")
    private List<WebElement> pricesListInput;

    @FindBy(css = ".numeric-item.price span.header")
    private List<WebElement> pricesListLabel;

    public PriceFilter(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void openMaxPriceRange() throws InterruptedException {
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
        scrollTo(pricesListButton.get(1));
        pricesListButton.get(1).click();
    }

    public void openMinPriceRange() throws InterruptedException {
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
        scrollTo(pricesListButton.get(0));
        pricesListButton.get(0).click();
    }


    public void setUpValueToMinPrice(String price) {
        pricesListInput.get(0).clear();
        pricesListInput.get(0).sendKeys(price);
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
        log.debug("Set min value");
    }

    public void setUpValueToMaxPrice(String price) {
        pricesListInput.get(1).clear();
        pricesListInput.get(1).sendKeys(price);
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
        log.debug("Set max value");
    }

    public void waitUntilMinPriceContains(String price) {
        webDriverWait.until(textToBePresentInElement(pricesListLabel.get(0), price));
    }

    public void waitUntilMaxPriceContains(String price) {
        webDriverWait.until(textToBePresentInElement(pricesListLabel.get(1), price));
    }

}
