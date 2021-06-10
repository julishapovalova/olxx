package com.olx.car.filter;

import com.olx.BaseTest;
import com.olx.listener.LogListener;
import com.olx.pages.component.filters.TransmissionsFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Listeners(LogListener.class)
public class TransmissionTest extends BaseTest {

    private static final String TRANSMISSION_TYPE = "Автоматическая";

    @Test
    public void shouldChooseTransmissionMode() throws InterruptedException {
        TransmissionsFilter filter = new TransmissionsFilter(driver, webDriverWait);
        filter.openTransitionDropDown();

        filter = new TransmissionsFilter(driver, webDriverWait);
        filter.chooseTransimission(TRANSMISSION_TYPE);

        assertThat(filter.isAllTransmissionsIsChecked()).isFalse();
    }

    @Test
    public void shouldChooseAllTransmissionModes() throws InterruptedException {
        TransmissionsFilter filter = new TransmissionsFilter(driver, webDriverWait);
        filter.openTransitionDropDown();

        filter = new TransmissionsFilter(driver, webDriverWait);
        filter.chooseTransimission("Все");

        assertThat(filter.isAllTransmissionsIsChecked()).isTrue();
    }
}
