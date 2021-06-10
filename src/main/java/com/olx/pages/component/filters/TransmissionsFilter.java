package com.olx.pages.component.filters;

import java.util.List;

import com.olx.pages.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class TransmissionsFilter extends Page {

    @FindBy(css = ".filter-item-transmission_type")
    private WebElement transmissionDropDown;

    @FindBy(css = "#f-all-filter_enum_transmission_type_47.all-checkbox")
    private WebElement allTrasmissionCheckBox;

    @FindBy(css = "#param_transmission_type label")
    private List<WebElement> transmissionLabel;

    @FindBy(css = "#param_transmission_type input")
    private List<WebElement> transmissionInput;

    @FindBy(css = "#param_transmission_type label")
    private List<WebElement> transmissionCheckboxList;

    public TransmissionsFilter(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }


    public boolean isAllTransmissionsIsChecked() throws InterruptedException {
        openTransitionDropDown();
        return transmissionInput.get(0).isSelected();
    }

    public void chooseTransimission(String transmissionsType) {
        for (int i = 0; i < transmissionLabel.size(); i = i + 2) {
            if (i == 0 && transmissionLabel.get(i).getText().equals(transmissionsType)) {
                transmissionLabel.get(i).click();
                break;
            } else if (transmissionLabel.get(i).getText().equals(transmissionsType)) {
                transmissionLabel.get(i - 1).click();
                break;
            }
        }
    }

    public void openTransitionDropDown() throws InterruptedException {
        scrollTo(transmissionDropDown);
        transmissionDropDown.click();
        log.info("Open trasmissions dropdown");
    }

}
