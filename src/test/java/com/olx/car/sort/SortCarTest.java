package com.olx.car.sort;

import java.util.List;

import com.olx.BaseTest;
import com.olx.listener.LogListener;
import com.olx.pages.SearchPage;
import com.olx.pages.component.Header;
import com.olx.pages.component.ResultModal;
import com.olx.pages.component.filters.PriceFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class SortCarTest extends BaseTest {

    @DataProvider(name = "numericPrice")
    public Object[][] validPriceData() {
        return new Object[][]{
                {"100000", "4000000"}
        };
    }

    @Test(dataProvider = "numericPrice")
    public void shouldSortCarResult(String minRange, String maxRange) throws InterruptedException {
        PriceFilter filter = new PriceFilter(driver, webDriverWait);
        filter.openMinPriceRange();
        filter.setUpValueToMinPrice(minRange);
        filter.openMaxPriceRange();
        filter.setUpValueToMaxPrice(maxRange);

        Header header = new Header(driver, webDriverWait);
        header.sortByLowHightPrice();
        List<Integer> getActualPrice = new ResultModal(driver, webDriverWait).getPrices();

        getActualPrice.forEach(actualPrice ->
                                       assertThat(actualPrice).isBetween(Integer.parseInt(minRange), Integer.parseInt(maxRange)));

    }

}
