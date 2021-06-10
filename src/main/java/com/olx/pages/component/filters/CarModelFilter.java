package com.olx.pages.component.filters;

import java.util.List;

import com.olx.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarModelFilter extends Page {


    @FindBy(css = "#param_subcat span.header")
    private WebElement carCategoryInput;

    @FindBy(css = "#param_subcat ul li a")
    private List<WebElement> carCategoryList;


    public CarModelFilter(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public boolean isContainsCarCategory(String carCategory) throws InterruptedException {
        scrollTo(carCategoryInput);
        carCategoryInput.click();
        return carCategoryList.stream().anyMatch(webElement -> webElement.getText().equals(carCategory));
    }
}
