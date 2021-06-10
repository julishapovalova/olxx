package com.olx.pages.component.filters;

import java.util.List;
import java.util.NoSuchElementException;

import com.olx.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class MiliageFilter extends Page {

    @FindBy(css = "#param_motor_mileage:first-child .button-from")
    private WebElement minMileageDropDown;

    @FindBy(css = "#param_motor_mileage:first-child li a")
    private List<WebElement> minMileageDropDownValue;

    @FindBy(css = "#param_motor_mileage .num-input input.from")
    private WebElement minMileageInput;

    @FindBy(css = "#param_motor_mileage:first-child .button-from span.block")
    private WebElement minMileageValue;

    @FindBy(css = "#param_motor_mileage:first-child .button-to")
    private WebElement maxMileageDropDown;

    @FindBy(css = "#param_motor_mileage:first-child li a")
    private List<WebElement> maxMileageDropDownValue;

    @FindBy(css = "#param_motor_mileage .num-input input.to")
    private WebElement maxMileageInput;

    @FindBy(css = "#param_motor_mileage .button-to span.block")
    private WebElement maxMileageValue;

    public MiliageFilter(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void openMinMiliageValue() throws InterruptedException {
        scrollTo(minMileageDropDown);
        minMileageDropDown.click();
    }

    public void chooseMiliageValueFromDropdown(String miliage) {
        minMileageDropDownValue.stream()
                               .filter(webElement ->
                                               webElement.getAttribute("data-name")
                                                         .replace(" ", "")
                                                         .equals(miliage))
                               .findFirst()
                               .orElseThrow(NoSuchElementException::new)
                               .click();
    }

    public void waitUntilMinMiliageContains(String miliage) {
        webDriverWait.until(textToBePresentInElement(minMileageValue, miliage));
    }

    public void setUpValueToMinMiliage(String miliage) {
        minMileageInput.clear();
        minMileageInput.sendKeys(miliage);
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
    }

    public void openMaxMiliageValue() throws InterruptedException {
        scrollTo(maxMileageDropDown);
        maxMileageDropDown.click();
    }

    public void chooseMaxMiliageValueFromDropdown(String miliage) {
        maxMileageDropDownValue.stream()
                               .filter(webElement ->
                                               webElement.getAttribute("data-name")
                                                         .replace(" ", "")
                                                         .equals(miliage))
                               .findFirst()
                               .orElseThrow(NoSuchElementException::new)
                               .click();
    }

    public void waitUntilMaxMiliageContains(String miliage) {
        webDriverWait.until(textToBePresentInElement(maxMileageValue, miliage));
    }

    public void setUpValueToMaxMiliage(String miliage) {
        maxMileageInput.clear();
        maxMileageInput.sendKeys(miliage);
        webDriverWait.until(not(attributeContains(listContainer, "class", "loaderActive")));
    }
}
