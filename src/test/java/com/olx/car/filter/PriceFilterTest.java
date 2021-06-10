package com.olx.car.filter;

import com.olx.BaseTest;
import com.olx.listener.LogListener;
import com.olx.pages.component.Search;
import com.olx.pages.component.filters.PriceFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
@Listeners(LogListener.class)
public class PriceFilterTest extends BaseTest {

    @DataProvider(name = "numericPrice")
    public Object[][] validPriceData() {
        return new Object[][]{
                {"123"}
        };
    }

    @DataProvider(name = "numericInvalidPrice")
    public Object[][] invalidPriceData() {
        return new Object[][]{
                {"qwer", ""},
                {"-", ""}
        };
    }

    @Test(dataProvider = "numericPrice")
    public void shouldFillMinPrice(String price) throws InterruptedException {
        PriceFilter filter = new PriceFilter(driver, webDriverWait);

        filter.openMinPriceRange();
        filter.setUpValueToMinPrice(price);

        filter.waitUntilMinPriceContains(price);
    }

    @Test(dataProvider = "numericInvalidPrice")
    public void shouldNotFillMinPrice(String price, String expectedResult) throws InterruptedException {
        PriceFilter filter = new PriceFilter(driver, webDriverWait);

        filter.openMinPriceRange();
        filter.setUpValueToMinPrice(price);

        filter.waitUntilMinPriceContains(expectedResult);
    }

    @Test(dataProvider = "numericPrice")
    public void shouldFillMaxPrice(String price) throws InterruptedException {
        PriceFilter filter = new PriceFilter(driver, webDriverWait);

        filter.openMaxPriceRange();
        filter.setUpValueToMaxPrice(price);

        filter.waitUntilMaxPriceContains(price);
    }

    @Test(dataProvider = "numericInvalidPrice")
    public void shouldNotFillMaxPrice(String price, String expectedResult) throws InterruptedException {
        PriceFilter filter = new PriceFilter(driver, webDriverWait);

        filter.openMaxPriceRange();
        filter.setUpValueToMaxPrice(price);

        filter.waitUntilMaxPriceContains(expectedResult);
    }
}
