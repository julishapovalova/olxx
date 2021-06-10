package com.olx.car.filter;

import com.olx.BaseTest;
import com.olx.listener.LogListener;
import com.olx.pages.component.filters.CarModelFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class CategoryFilterTest extends BaseTest {

    @DataProvider(name = "carCategory")
    public Object[][] carCategoryData() {
        return new Object[][]{
                {"Honda"},
                {"Mazda"}
        };
    }

    @Test(dataProvider = "carCategory")
    public void shouldContainsCarCategory(String carCategory) throws InterruptedException {
        CarModelFilter filter = new CarModelFilter(driver, webDriverWait);

        assertThat(filter.isContainsCarCategory(carCategory)).isTrue();
    }
}
