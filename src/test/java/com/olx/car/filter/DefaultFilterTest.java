package com.olx.car.filter;

import com.olx.BaseTest;
import com.olx.pages.SearchPage;
import com.olx.pages.component.Search;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultFilterTest extends BaseTest {

    private static final String EXPECTED_CATEGORY = "Легковые автомобили";

    private Search filter;

    @Test
    public void shouldContainsDefaultFilters() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver, webDriverWait);
        filter = searchPage.getFilter();

        assertThat(filter.getTextFromSearchTextBox()).isNotEmpty();
        assertThat(filter.getSelectedRegionFromDropDown()).isNotEmpty();
        assertThat(filter.getCarCategory()).isEqualTo(EXPECTED_CATEGORY);
    }
}
