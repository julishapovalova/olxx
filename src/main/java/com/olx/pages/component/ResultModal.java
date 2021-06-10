package com.olx.pages.component;

import java.util.List;
import java.util.stream.Collectors;

import com.olx.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ResultModal extends Page {

    @FindBy(css = "p.price strong")
    List<WebElement> prices;

    @FindBy(css = ".dontHasPromoted h2")
    WebElement offerSection;

    public ResultModal(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public List<Integer> getPrices() throws InterruptedException {
        webDriverWait.until(visibilityOf(offerSection));
        return prices.stream()
                     .map(webElement -> {
                         String element = webElement.getText();
                         element = element.replace(" ", "").substring(0, element.length() - 6);
                         return Integer.parseInt(element);
                     })
                     .collect(Collectors.toList());
    }
}
