package com.olx.car.filter;

import com.olx.BaseTest;
import com.olx.listener.LogListener;
import com.olx.pages.component.filters.MiliageFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Slf4j
@Listeners(LogListener.class)
public class MileageFilterTest extends BaseTest {

    @DataProvider(name = "miliageValue")
    public Object[][] validPriceData() {
        return new Object[][]{
                {"100000", "250000"}
        };
    }

    @Test(dataProvider = "miliageValue")
    public void shouldChooseMinMiliageFromDropdown(String minMiliage, String maxMiliage) throws InterruptedException {
        MiliageFilter miliageFilter = new MiliageFilter(driver, webDriverWait);

        miliageFilter.openMinMiliageValue();
        miliageFilter.chooseMiliageValueFromDropdown(minMiliage);

        miliageFilter.openMaxMiliageValue();
        miliageFilter.setUpValueToMaxMiliage(maxMiliage);

        miliageFilter.waitUntilMinMiliageContains(minMiliage);
        miliageFilter.waitUntilMaxMiliageContains(maxMiliage);
    }
}
