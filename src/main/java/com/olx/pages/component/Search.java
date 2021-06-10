package com.olx.pages.component;

import com.olx.pages.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class Search extends Page {

    @FindBy(css = "#search-text")
    private WebElement searchTextBox;

    @FindBy(css = "#cityField")
    private WebElement regionDropdown;

    @FindBy(css = ".category-icon span span")
    private WebElement categoryDropDown;

    @FindBy(css = ".category.rel.zi3.clr")
    private WebElement carBrandDropDown;

    public Search(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public String getTextFromSearchTextBox() {
        webDriverWait.until(visibilityOf(searchTextBox));
        return searchTextBox.getAttribute("value");
    }

    public String getSelectedRegionFromDropDown() {
        return regionDropdown.getAttribute("value");
    }

    public String getCarCategory() throws InterruptedException {
        scrollTo(carBrandDropDown);
        return categoryDropDown.getText();
    }
}
