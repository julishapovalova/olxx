package com.olx.pages.component;

import com.olx.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class Header extends Page {

    @FindBy(css = "#targetorder-select-gallery ul li:nth-child(2)")
    WebElement sortFromLowToHighItem;

    @FindBy(css = "#targetorder-select-gallery")
    WebElement defaultSortItem;

    public Header(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void sortByLowHightPrice() throws InterruptedException {
        scrollTo(defaultSortItem);
        defaultSortItem.click();
        sortFromLowToHighItem.click();
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
    }
}
