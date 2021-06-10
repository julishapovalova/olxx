package com.olx.pages;

import com.olx.pages.component.Search;
import com.olx.pages.component.Header;
import com.olx.pages.component.ResultModal;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Getter
@Setter
public class SearchPage extends Page {


    public Search filter = new Search(webDriver, webDriverWait);
    public ResultModal resultModal = new ResultModal(webDriver, webDriverWait);
    public Header header = new Header(webDriver, webDriverWait);

    @FindBy(css = "#search-text")
    WebElement searchText;

    public SearchPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
        webDriverWait.until(visibilityOf(searchText));
    }

}
